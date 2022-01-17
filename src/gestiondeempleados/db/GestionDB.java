/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.db;

import gestiondeempleados.ManagerDepartamentos;
import gestiondeempleados.modelos.Departamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class GestionDB {

    private String user;
    private String password;
    private String host;
    private String db;
    public Connection conn;

    public GestionDB() {
    }

    public GestionDB(String user, String password, String host, String db) {
        this.user = user;
        this.password = password;
        this.host = host;
        this.db = db;
    }

 
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/empresa", user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public Connection getConexion() {
        return conn;
    }
}
