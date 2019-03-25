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
 * @author stagldnr
 */
public interface DAO_Julien<T> {
    Connection connection = Connection_Julien.getInstance();
    /**
     * 
     * @param id l'identifiant de l'objet a recuperer
     * @return L'objet ayant l'identifiant id
     */

    T find(Integer id);
    
    T create(T obj);
    
    void deleted(T obj);
    
    T update(T obj);
    
    List<T> findAll();
    
    
}
