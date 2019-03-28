/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import Pkg_DAO.Question_Julien;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
import static javax.swing.JOptionPane.showConfirmDialog;
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
    int choix, confirmation;
    LabelAndPassword askMDP;
    
    /**
     * Constructeur onglet administration
     */
    public Administration_Yann() {
        alreadyShown=false;
        this.initAdmin();
    }
    
    /**
     * Vide et re-remplit l'onglet administration
     */
    public void initAdmin() {
        alreadyShown=false;
        this.removeAll();
        this.setName("Administration");
        
        //panneau inséré à l'onglet (pas utile)
        orga =new JPanel();
        global = new JPanel();
        global.setLayout(new BorderLayout());
        orga.setLayout(new BoxLayout(orga,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        //Champ de saisie du mot de passe
        askMDP = new LabelAndPassword("Veuillez saisir votre mot de passe");
        TitledBorder borderAdmin = new TitledBorder("Bienvenue dans l'interface d'administration");
        orga.setBorder(borderAdmin);
        
        erreur = new JLabel("Mot de passe erroné, veuillez réessayer");

        orga.add(askMDP);
        
        //Quand appui sur entrée sur le champ MDP
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
        
        //Quand le champ mdp est modifié
        //le message mauvais mot de passe est retiré
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
        
        //Si validation, test du MDP, si faux affichage message erreur
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
        
        //rechargement de l'ongelt
        orga.add(checkMDP);
        global.add(orga,BorderLayout.CENTER);
        this.add(global,BorderLayout.CENTER);
        askMDP.getTextField().grabFocus();
    }
    
    /**
     * Vérification du mot de passe
     * @param essai le mot saisi dans le champ texte
     * @return true si mot de passe ok
     */
    public boolean verifierMDP(String essai)
    {
        //Chiffrement du mot de passe entré, pour comparaison
        String essaiChiffre="";
        for (int i=0;i<essai.length();i++)
        {
            essaiChiffre+=(char)(essai.charAt(i)+5);
        }
        
        //Lecture du mot de passe
        try (BufferedReader in = new BufferedReader(new FileReader("password.txt")))
        {
          mdp = in.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //test de comparaison
        if (mdp.equals(essaiChiffre))
            {
                return true;
            }
            else if (essai.equals("pendu"))
            {
                
                this.getParent().add(new Surprise());
                return false;
            }
            else
            {
                return false;
            }
    }

    /**
     * Chargement de la page après vérification du MDP
     */
    public void initAdmiValidated() {
        orga.removeAll();
        boutonsChoix = new JPanel(new GridLayout(0,2));
        orga.add(boutonsChoix);
        TitledBorder borderQuestions = new TitledBorder("Modifiez ou Ajoutez une question :");
        boutonsChoix.setBorder(borderQuestions);
        
        Bouton modifier = new Bouton("Modifier");
        Bouton ajouter = new Bouton("Ajouter");
        
        //Chargement de la page de modification
        modifier.addActionListener((ActionEvent e) -> {
            initModifierQuestion(0);            
        });
        
        //Chargement de la page d'ajout
        ajouter.addActionListener((ActionEvent e) -> {
            initAjouterQuestion();            
        });
        
        boutonsChoix.add(modifier);
        boutonsChoix.add(ajouter);
        
        //Zone de changement du mot de passe
        LabelAndField changeMDP = new LabelAndField("Nouveau mot de passe (min 5 caractères)");
        TitledBorder borderNewMDP = new TitledBorder("Changez votre mot de passe :");
        changeMDP.setBorder(borderNewMDP);
        
        //Listener si appui entrée dans la zone de changement de mot de passe
        changeMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP(changeMDP.getTextField().getText());
                if (alreadyShown2==false)
                {
                    if (confirmation ==0)
                    {
                        orga.add(changed);
                        alreadyShown=true;
                    }
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().setText("");
                    
                }
            }
        });
        
        //Quand le champ mdp est modifié
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
        
        //Rechargement de la page après valdiation
        //+Pop-up de validation
        validerMDP.addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP(changeMDP.getTextField().getText());
                if (alreadyShown2==false)
                {
                    if (confirmation ==0)
                    {
                        orga.add(changed);
                        alreadyShown=true;
                    }
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    changeMDP.getTextField().setText("");
                   
                }
            }            
        });
        orga.add(changeMDP);
        orga.add(validerMDP);
    }
    
    /**
     * Changement du mot de passe
     * @param mdp le nouveau mot de passe
     */
    private void changeMDP(String mdp) {
        
        //Chiffrement du mot de passe
        String mdpChiffre="";
        for (int i=0;i<mdp.length();i++)
        {
            mdpChiffre+=(char)(mdp.charAt(i)+5);
        }
        
        //pop up de confirmation
        confirmation = showConfirmDialog(null,
                                        "Vous allez redéfinir le mot de passe, continuer?",
                                        "Nouveau mot de passe",
                                        2);
        
        //Si pop validée
        if (confirmation==0)
        {
            changed = new JLabel("Mot de passe modifié avec succès");
            try (BufferedWriter out = new BufferedWriter(new FileWriter("password.txt")))
            {
              out.write(mdpChiffre);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Création de l'onglet de modification de la question
     * @param selected l'index de la question choisie dans la liste
     */
    private void initModifierQuestion(int selected) {
        
                
        Question_Julien qJ = new Question_Julien();
        listQuestions = qJ.findAll();
        listString.clear();
        
        //Création de la liste de strings question
        for (Question question : listQuestions)
        {
            listString.add(question.toString());
        }
        choix = selected;
        
        //Création du menu déroulant des questions
        menuDeroulantQuestions = new ComboBox("Sélectionnez votre question",listString);
        menuDeroulantQuestions.getMenuDeroulant().setSelectedIndex(choix);
        menuDeroulantQuestions.getMenuDeroulant().addActionListener((ActionEvent e) -> {
            
            //Récupération de l'index de la question pour remplissage textbox et choix niveau
            choix = menuDeroulantQuestions.getMenuDeroulant().getSelectedIndex();
            
            initModifierQuestion(choix);
            });
        
            orga.removeAll();
            questionChoisie = (Question)listQuestions.toArray()[choix];    
            
        
            // Création de la zone de question réponse
            qRLTF = new QuestionReponseLTF(questionChoisie.getQuestions(),questionChoisie.getReponse());
        
            boutonsEtNiveau = new JPanel(new GridLayout(0,4,10,10));
        
            TitledBorder borderAjouter = new TitledBorder("Modifiez une question :");
            orga.setBorder(borderAjouter);
            
            //Appelle la fonction update avec l'objet question correspondant à l'index
            Bouton valider = new Bouton("Modifier");
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
            questionToDB = createQuestion(questionChoisie.getId());        
            qJ.update(questionToDB);
            JOptionPane.showMessageDialog(null,
                                        "Question N°" + questionChoisie.getId() + " modifiée",
                                        "Modification de question",
                                        JOptionPane.INFORMATION_MESSAGE);
            initModifierQuestion(0);
            }
        });
        
        //Appelle la fonction deleted avec l'objet question correspondant à l'index    
        Bouton supprimer = new Bouton("Supprimer");
        supprimer.addActionListener((ActionEvent g) -> {
            confirmation = showConfirmDialog(null,
                                        "Vous allez supprimer définitivement la question N°" + questionChoisie.getId() +", continuer ?",
                                        "Suppression de question",
                                        2);
            if (confirmation==0)
            {
                questionToDB = createQuestion(questionChoisie.getId());
                try
                {
                    qJ.deleted(questionToDB);
                }
                catch(Exception e){
                    
                }
                JOptionPane.showMessageDialog(null,
                                        "Question N°" + questionChoisie.getId() + " supprimée",
                                        "Suppression de question",
                                        JOptionPane.INFORMATION_MESSAGE);
                initModifierQuestion(0);
            }
        });    
            
        Bouton retour = new Bouton("Retour");
        retour.addActionListener((ActionEvent g) -> {
            initAdmiValidated();
        });
        
        radioNiveau = new RadioNiveau(questionChoisie.getNiveau_question());
        boutonsEtNiveau.add(radioNiveau);
        boutonsEtNiveau.add(valider);
        boutonsEtNiveau.add(supprimer);
        boutonsEtNiveau.add(retour);
        orga.add(menuDeroulantQuestions);
        orga.add(qRLTF);
        orga.add(boutonsEtNiveau);
        
    }
    
    /**
     * Création de l'onglet d'ajout de question
     */
    private void initAjouterQuestion() {
        
        orga.removeAll();
        
        qRLTF = new QuestionReponseLTF("","");
        
        boutonsEtNiveau = new JPanel(new GridLayout(0,3,10,10));
        
        TitledBorder borderAjouter = new TitledBorder("Ajoutez une question :");
        orga.setBorder(borderAjouter);
        
        //Appelle la fonction create avec l'objet question récupéré dans les champs
        Bouton valider = new Bouton("Enregistrer");
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
            questionToDB = createQuestion(0);
            Question_Julien qJ = new Question_Julien();
            Question retour;
            retour = qJ.create(questionToDB);
            JOptionPane.showMessageDialog(null,
                                        "Question N°" + retour.getId() + " créée",
                                        "Création de question",
                                        JOptionPane.INFORMATION_MESSAGE);
            initAjouterQuestion();
            }
        });
        
        
        Bouton retour = new Bouton("Retour");
        retour.addActionListener((ActionEvent e) -> {
            initAdmiValidated();
        });
        if (choix!=0)
        {
            radioNiveau = new RadioNiveau(questionChoisie.getNiveau_question());
        }
        else
        {
            radioNiveau = new RadioNiveau(1);
        }
        boutonsEtNiveau.add(radioNiveau);
        boutonsEtNiveau.add(valider);
        boutonsEtNiveau.add(retour);
        orga.add(qRLTF);
        orga.add(boutonsEtNiveau);
    }
    
    /**
     * Création de l'objet question par rapport au champs de l'onglet ajout ou  modifier
     * @param idQuestion est inutile dans le cas d'un ajout de question, mais sert en modification
     */
    private Question createQuestion(int idQuestion) {
        
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
                                idQuestion,
                                question,
                                reponse,
                                niveau);
        return objet;
        
    }
   
}
