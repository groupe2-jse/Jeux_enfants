/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;


/**
 *
 * @author Expression zine is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Question {
 private Integer id_question;
    private Integer niveau_question ;
    private String questions;
   
    private String reponse;

    public Question(int id_question,String questions,String reponse,int niveau_question) {
        this.id_question= id_question;
        this.niveau_question = niveau_question;
        this.questions= questions;
        this.reponse= reponse;
       
    }

    public Integer getId_question() {
        return id_question;
    }

    public void setId_question(Integer id_question) {
        this.id_question = id_question;
    }

    public Integer getNiveau_question() {
        return niveau_question;
    }

    public void setNiveau_question(Integer niveau_question) {
        this.niveau_question = niveau_question;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
   
}
