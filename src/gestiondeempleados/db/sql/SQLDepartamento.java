/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.db.sql;

import gestiondeempleados.db.GestionDBConn;
import gestiondeempleados.modelos.Departamento;
import gestiondeempleados.enums.QType;
import gestiondeempleados.logica.ManagerDepartamentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class SQLDepartamento {

    GestionDBConn GDB = GestionDBConn.getInstance();
    ManagerDepartamentos MD = new ManagerDepartamentos();
    
    public ManagerDepartamentos manager() {
        return MD;
    }
 
    public boolean departamentoQuery(Departamento dept, QType type, String modificacion) {
        boolean resultadoQuery = false;

        GDB.conectar();

        try {
            Statement sentence = GDB.conn.createStatement();
            String sql;
              
            switch(type) {
                case NEW:
                    sentence = GDB.conn.createStatement();
                    sql = String.format("INSERT INTO departamento VALUES (%s, '%s')", dept.getIdDepartamento(), dept.getNombre());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case DELETE:
                    sentence = GDB.conn.createStatement();
                    sql = String.format("DELETE from departamento where idDepartamento = %s", dept.getIdDepartamento());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case MODIFY:
                    sql = String.format("UPDATE departamento set Nombre = ('%s') where idDepartamento = %s", modificacion, dept.getIdDepartamento());

                    //Ejecutamos la sentencia
                    resultadoQuery = sentence.execute(sql);
                    break;
            }
            sentence.close();
            GDB.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoQuery;
    }

    public ManagerDepartamentos listarDepartamentos() {
        ManagerDepartamentos listado = MD;
        ResultSet rs;
        //Conectar con la base de datos
        GDB.conectar();

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
                listado.add(new Departamento(rs.getInt(1), rs.getString(2)));
            }

            rs.close();
            sentence.close();
            GDB.desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(GestionDBConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listado;
    }

}
