/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import access.userDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ConnectionDB {

    public static Connection getConnection() {
        JSONParser parser = new JSONParser();
        Connection conn = null;

        // conectar
        try {
            String credentials_path = System.getProperty("user.dir") + "/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));

            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String schema_name = "users";
            String dbURL = "jdbc:mysql://"+host+":"+port+"/" + schema_name;

            conn = DriverManager.getConnection(dbURL, username, password);
//            if( conn != null )
//            System.out.println ( "Conectado" );

        }
        catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        }
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args){
        getConnection();

    }
}
