/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pkg_Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagldnr
 */
public class Connection_Julien {
    
    private static Connection connection = null;
    
    public static  Connection getInstance()
    {
        if(connection == null)
        {
            Properties config = new Properties();
            try(InputStream in = Connection_Julien.class.getResourceAsStream("/Pkg_Ressource/config.properties")){
                    config.load(in);
            }
            catch(IOException ex)
            {
                Logger.getLogger(Connection_Julien.class.getName()).log(Level.SEVERE, null,ex);
                System.exit(1);
            }
            
            String url = "jdbc:"+ config.getProperty("sgbdr")
                    +"://"+config.getProperty("host")
                    +":"+ config.getProperty("port")
                    +"/"+ config.getProperty("database");
            try{
                connection = DriverManager.getConnection(url, config);
            }catch(SQLException ex){
                Logger.getLogger(Connection_Julien.class.getName()).log(Level.SEVERE, null,ex);
            }
            
          return connection;
            
                    
        }
            
        return connection;
    }
}
