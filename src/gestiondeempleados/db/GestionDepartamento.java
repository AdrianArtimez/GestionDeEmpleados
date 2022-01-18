/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.db;

import gestiondeempleados.ManagerDepartamentos;
import gestiondeempleados.modelos.Departamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class GestionDepartamento {
    
    GestionDB GDB = new GestionDB("userdb","1234","localhost","empresa");
    ManagerDepartamentos MD = new ManagerDepartamentos();
        
    private void conectar() {
        GDB.conectar();
    }
    
    private void desconectar() {
        GDB.desconectar();
    }
    
    //Metodo insertar departamento
    public boolean insertarDepartamento(Departamento dept) {
        boolean resultadoInsertar = true;

        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {

            int dep = dept.getIdDepartamento();
            String name = dept.getNombre();
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("INSERT INTO departamento VALUES (%s, '%s')", dep, name);
            resultadoInsertar = sentence.execute(sql);           
            sentence.close();
            MD.addDepartamento(dept);
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoInsertar;
    }

    //Metodo insertar departamento
    public boolean modificarDepartamento(int deptID, int newID) {
        boolean resultadoInsertar = true;

        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("UPDATE departamento set idDepartamento = ('%s') where idDepartamento = %s", newID, deptID);
            resultadoInsertar = sentence.execute(sql);
            sentence.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoInsertar;
    }

    public boolean modificarDepartamento(int deptID, String newName) {
        boolean resultadoInsertar = true;
        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("UPDATE departamento set Nombre = ('%s') where idDepartamento = %s", newName, deptID);
            resultadoInsertar = sentence.execute(sql);
            sentence.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultadoInsertar;
    }

    public boolean eliminarDepartamento(int deptID) {
        boolean resultadoInsertar = true;
        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("DELETE from departamento where idDepartamento = %s", deptID);
            resultadoInsertar = sentence.execute(sql);
            sentence.close();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoInsertar;
    }

    public Departamento buscarDepartamento(String deptName) {
        //Conectar con la base de datos
        conectar();
        Departamento dept_res = null;
        ResultSet rs;

        //Enviar la modificacion a la base de datos
        try {
            Statement sentence = GDB.conn.createStatement();
            String sql = String.format("SELECT idDepartamento,Nombre FROM departamento WHERE nombre='%s'",
                     deptName);
            sentence.execute(sql);
            rs = sentence.getResultSet();

            while (rs.next()) {
                dept_res = new Departamento(rs.getInt(1), rs.getString(2));
            }

            rs.close();
            sentence.close();
            desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dept_res;
    }
    
   public ManagerDepartamentos listarDepartamentos() {
        ManagerDepartamentos listado = new ManagerDepartamentos();
        ResultSet rs;
        //Conectar con la base de datos
        conectar();

        //Enviar la modificacion a la base de datos
        try {
            //Creamos la sentencia
            Statement sentence = GDB.conn.createStatement();
            // Y la syntax de la sentencia
            String sql = "SELECT * FROM departamento";
            //Ejecutar la consulta
            sentence.execute(sql);
            //Obtengo el resultset
            rs = sentence.getResultSet();

            while (rs.next()) {
                listado.addDepartamento(new Departamento(rs.getInt(1), rs.getString(2)));
            }

            rs.close();
            sentence.close();
            desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(GestionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

}
