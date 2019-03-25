/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pkg_DAO;

/**
 *
 * @author stagldnr
 */
//import static Pkg_DAO.DAO_Julien.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import zine.Question;

public class Question_Julien implements DAO_Julien<Question>{
    
    private String table = "Question";
    
    
    @Override
    public Question find(Integer id_question) {

        Question retObj = null;
        String sql = "SELECT * FROM "
               + table
               + " WHERE id_question_Questions=?";
        try{
           PreparedStatement pstmt = connection.prepareStatement(sql);
           pstmt.setInt(1, id_question);
           ResultSet rs = pstmt.executeQuery();
           if(rs.first()){
            retObj =  new Question(id_question,
                        rs.getString("questions"),
                        rs.getString("reponse"),
                        rs.getInt("niveau_question"));
           }
       }
       catch(SQLException ex){
           Logger.getLogger(DAO_Julien.class.getName()).log(Level.SEVERE,null,ex);
       }
        return retObj;
    }

    @Override
    public Question create(Question obj) {
        Question retObj = null;
        String sql = "INSERT INTO " +
                    table +
                    "(question , reponse , niveau_question)"
                    + " VALUES(?,?,?)" ;
        
        try {
            
            PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getQuestions());
            pstmt.setString(2, obj.getReponse());
            pstmt.setInt(3, obj.getNiveau_question());
            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if(generatedKeys.first()){
               // obj.setId_personne(generatedKeys.getInt(1));
                retObj = this.find(generatedKeys.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Julien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
            
    }

    @Override
    public void deleted(Question obj) {

        try {
            String sql = "DELETE FROM "+ table+ " WHERE id_questions_Questions=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_question());
            int nombreLigneImpactees = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Julien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Question update(Question obj) {

        Question retObj = null;
        String sql = "UPDATE "
                +table
                +" SET questions=?,"
                +" reponse=?,"
                +" niveau_question=?,"
                +" WHERE id_question_Questions=?";
  

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,obj.getQuestions());
            pstmt.setString(2,obj.getReponse());
            pstmt.setInt(3,obj.getNiveau_question());
            pstmt.executeUpdate();
            retObj = find(obj.getId_question());
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Julien.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return retObj;
    }

    @Override
    public List<Question> findAll() {

         ArrayList<Question> retObj = new ArrayList<>();
        String sql = "SELECT * FROM "
               + table;
        try{
           PreparedStatement pstmt = connection.prepareStatement(sql);          
           ResultSet rs = pstmt.executeQuery();
           while(rs.next()){
            retObj.add (new Question(
                    rs.getInt("id_question"),
                    rs.getString("questions"),
                    rs.getString("preponse"),
                    rs.getInt("niveau_question")
           ));
           }
       }
       catch(SQLException ex){
           Logger.getLogger(DAO_Julien.class.getName()).log(Level.SEVERE,null,ex);
       }
        return retObj;

    }
    
    
}
