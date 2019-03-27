/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import Pkg_DAO.Question_Julien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jeux_enfant.Tablet;
import zine.LabelAndField;
import zine.Question;

/**
 *
 * @author Yann Golhen
 */
public final class Administration_Yann extends JPanel{

    boolean alreadyShown, alreadyShown2;
    JLabel erreur, changed;
    JPanel global, orga, boutonsChoix, boutonsEtNiveau;
    String mdp;
    Question objet, questionToDB, questionChoisie;
    QuestionReponseLTF qRLTF;
    RadioNiveau radioNiveau;
    List<Question> listQuestions;
    List<String> listString = new ArrayList<>();
    ComboBox menuDeroulantQuestions;
    int choix;
    
    public Administration_Yann() {
        alreadyShown=false;
        this.initAdmin();
    }

    public void initAdmin() {
        alreadyShown=false;
        this.removeAll();
        this.setName("Administration");
        orga =new JPanel();
        global = new JPanel();
        global.setLayout(new BorderLayout());
        orga.setLayout(new BoxLayout(orga,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        LabelAndField askMDP = new LabelAndField("Veuillez saisir votre mot de passe");
        TitledBorder borderAdmin = new TitledBorder("Bienvenue dans l'interface d'administration");
        orga.setBorder(borderAdmin);

        erreur = new JLabel("Mot de passe erroné, veuillez réessayer");

        orga.add(askMDP);
        
        askMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (verifierMDP(askMDP.getTextField().getText()))
            {
                initAdmiValidated();
            }
            else if (alreadyShown==false)
            {
                orga.add(erreur);
                global.removeAll();
                global.add(orga,BorderLayout.CENTER);
                askMDP.getTextField().setText("");
                alreadyShown=true;
            }
        });
        
        askMDP.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    askMDP.getTextField().grabFocus();
                    alreadyShown=false;
                    
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    askMDP.getTextField().grabFocus();
                    alreadyShown=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    alreadyShown=false;
                }
            }
        });
        
        //Ajout bouton valider lancant la méthode de vérification
        Bouton checkMDP = new Bouton("Valider");
        checkMDP.addActionListener((ActionEvent e) -> {
            if (verifierMDP(askMDP.getTextField().getText()))
            {
                initAdmiValidated();
            }
            else if (alreadyShown==false)
            {
                orga.add(erreur);
                global.removeAll();
                global.add(orga,BorderLayout.CENTER);
                askMDP.getTextField().setText("");
                alreadyShown=true;
            }
        });
        
        orga.add(checkMDP);
        global.add(orga,BorderLayout.CENTER);
        this.add(global,BorderLayout.CENTER);
        askMDP.getTextField().grabFocus();
    }
    
    public boolean verifierMDP(String essai)
    {
        String essaiChiffre="";
        for (int i=0;i<essai.length();i++)
        {
            essaiChiffre+=(char)(essai.charAt(i)+5);
        }
        
        try (BufferedReader in = new BufferedReader(new FileReader("password.txt")))
        {
          mdp = in.readLine();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mdp.equals(essaiChiffre))
            {
                return true;
            }
            else
            {
                return false;
            }
    }

    public void initAdmiValidated() {
        orga.removeAll();
        boutonsChoix = new JPanel(new GridLayout(0,2));
        orga.add(boutonsChoix);
        TitledBorder borderQuestions = new TitledBorder("Modifiez ou Ajoutez une question :");
        boutonsChoix.setBorder(borderQuestions);
        
        Bouton modifier = new Bouton("Modifier");
        Bouton ajouter = new Bouton("Ajouter");
        
        modifier.addActionListener((ActionEvent e) -> {
            initModifierQuestion();            
        });
        
        ajouter.addActionListener((ActionEvent e) -> {
            initAjouterQuestion();            
        });
        
        boutonsChoix.add(modifier);
        boutonsChoix.add(ajouter);
        
        //orga.add(new JLabel("Changez votre mot de passe :"));
        LabelAndField changeMDP = new LabelAndField("Nouveau mot de passe (min 5 caractères)");
        TitledBorder borderNewMDP = new TitledBorder("Changez votre mot de passe :");
        changeMDP.setBorder(borderNewMDP);
        changed = new JLabel("Mot de passe modifié avec succès");
        changeMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP(changeMDP.getTextField().getText());
                if (alreadyShown2==false)
                {
                    orga.add(changed);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().setText("");
                    alreadyShown=true;
                }
            }
        });
        
        changeMDP.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (alreadyShown2)
                {
                    
                    orga.remove(changed);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().grabFocus();
                    alreadyShown2=false;
                    
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (alreadyShown2)
                {
                    orga.remove(changed);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().grabFocus();
                    alreadyShown2=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (alreadyShown2)
                {
                    orga.remove(changed);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    alreadyShown2=false;
                }
            }
        });
        
        Bouton validerMDP = new Bouton("Valider");
        validerMDP.addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP(changeMDP.getTextField().getText());
                if (alreadyShown2==false)
                {
                    orga.add(changed);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().setText("");
                    alreadyShown=true;
                }
            }            
        });
        orga.add(changeMDP);
        orga.add(validerMDP);
    }

    private void changeMDP(String mdp) {
        String mdpChiffre="";
        for (int i=0;i<mdp.length();i++)
        {
            mdpChiffre+=(char)(mdp.charAt(i)+5);
        }
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter("password.txt")))
        {
          out.write(mdpChiffre);
          
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initModifierQuestion() {
        
                
        Question_Julien qJ = new Question_Julien();
        listQuestions = qJ.findAll();
                for (Question question : listQuestions)
        {
            listString.add(question.toString());
        }
        choix=0;
        menuDeroulantQuestions = new ComboBox("Sélectionnez votre question",listString);
        menuDeroulantQuestions.getMenuDeroulant().addActionListener((ActionEvent e) -> {
            choix = menuDeroulantQuestions.getMenuDeroulant().getSelectedIndex();
            
            });
            orga.removeAll();
                
            questionChoisie = (Question)listQuestions.toArray()[choix];
        
        
            qRLTF = new QuestionReponseLTF(questionChoisie.getQuestions(),questionChoisie.getReponse());
        
            boutonsEtNiveau = new JPanel(new GridLayout(0,3,10,10));
        
            TitledBorder borderAjouter = new TitledBorder("Modifiez une question :");
            orga.setBorder(borderAjouter);
        
            Bouton valider = new Bouton("Valider");
            valider.addActionListener((ActionEvent f) -> {
            if (qRLTF.getQuestion().getTextField().getText().length()==0)
            {
                JOptionPane.showMessageDialog(null
                    ,"Veuillez saisir une question"
                    ,"Attention ! "
                    ,JOptionPane.ERROR_MESSAGE);
            }
            else if (qRLTF.getReponse().getTextField().getText().length()==0)
            {
                JOptionPane.showMessageDialog(null
                    ,"Veuillez saisir une réponse"
                    ,"Attention ! "
                    ,JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            questionToDB = createQuestion();        
            qJ.update(questionToDB);
            initModifierQuestion();
            }
        });
        
        Bouton retour = new Bouton("Retour");
        retour.addActionListener((ActionEvent g) -> {
            initAdmiValidated();
        });
        
        radioNiveau = new RadioNiveau();
        boutonsEtNiveau.add(radioNiveau);
        boutonsEtNiveau.add(valider);
        boutonsEtNiveau.add(retour);
        orga.add(menuDeroulantQuestions);
        orga.add(qRLTF);
        orga.add(boutonsEtNiveau);
        
    }

    private void initAjouterQuestion() {
        
        orga.removeAll();
        
        qRLTF = new QuestionReponseLTF("","");
        
        boutonsEtNiveau = new JPanel(new GridLayout(0,3,10,10));
        
        TitledBorder borderAjouter = new TitledBorder("Ajoutez une question :");
        orga.setBorder(borderAjouter);
        
        Bouton valider = new Bouton("Valider");
        valider.addActionListener((ActionEvent e) -> {
            if (qRLTF.getQuestion().getTextField().getText().length()==0)
            {
                JOptionPane.showMessageDialog(null
                    ,"Veuillez saisir une question"
                    ,"Attention ! "
                    ,JOptionPane.ERROR_MESSAGE);
            }
            else if (qRLTF.getReponse().getTextField().getText().length()==0)
            {
                JOptionPane.showMessageDialog(null
                    ,"Veuillez saisir une réponse"
                    ,"Attention ! "
                    ,JOptionPane.ERROR_MESSAGE);
            }
            else
            {
            questionToDB = createQuestion();
            Question_Julien qJ = new Question_Julien();
            qJ.create(questionToDB);
            initAjouterQuestion();
            }
        });
        
        
        Bouton retour = new Bouton("Retour");
        retour.addActionListener((ActionEvent e) -> {
            initAdmiValidated();
        });
        radioNiveau = new RadioNiveau();
        boutonsEtNiveau.add(radioNiveau);
        boutonsEtNiveau.add(valider);
        boutonsEtNiveau.add(retour);
        orga.add(qRLTF);
        orga.add(boutonsEtNiveau);
    }

    private Question createQuestion() {
        
        String question, reponse;
        int niveau;
        
        question=qRLTF.getQuestion().getTextField().getText();
        reponse=qRLTF.getReponse().getTextField().getText();
        
        if (radioNiveau.getbNiveau1().isSelected())
        {
            niveau=1;
        }
        else
        {
            niveau=2;
        }
        
        objet = new Question(
                                0,
                                question,
                                reponse,
                                niveau);
        return objet;
        
    }

    
}
