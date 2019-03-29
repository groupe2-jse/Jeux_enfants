/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pkg_DAO;

import Pkg_Connection.Connection_Julien;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Julien
 */
public interface DAO_Julien<T> {
    //Création de la connexion 
    Connection connection = Connection_Julien.getInstance();
    /**
     * 
     * @param id l'identifiant de l'objet a recuperer
     * @return L'objet ayant l'identifiant id
     */

    //Permet de récupérer l'objet via son ID
    T find(Integer id);
    
    //Permet la création d'une entrée dans la table
    T create(T obj);
    
    //Permet la suppression  d'une entrée de la table
    void deleted(T obj);
    
    //Permet de mettre à jour les données d'une entré dans la table
    T update(T obj);
    
    //Permet de récuperer Toutes les entrées de la table
    List<T> findAll();
    
    
}
