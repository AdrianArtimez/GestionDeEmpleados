/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.db.sql;

import gestiondeempleados.db.GestionDBConn;
import gestiondeempleados.logica.ManagerEmpleados;
import gestiondeempleados.modelos.Departamento;
import gestiondeempleados.enums.QType;
import gestiondeempleados.modelos.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adria
 */
public class SQLEmpleado {

    GestionDBConn GDB = GestionDBConn.getInstance();
    ManagerEmpleados ME = new ManagerEmpleados();
    
    public ManagerEmpleados manager() {
        return ME;
    }
 
    public boolean empleadoQuery(Empleado emp, Empleado modificacion,QType type) {
        boolean resultadoQuery = false;

        GDB.conectar();

        try {
            Statement sentence = GDB.conn.createStatement();
            String sql;
            
            switch(type) {
                case NEW:
                    sql = String.format("INSERT INTO empleados (Nombre,Apellidos,codDepartamento,Salario,Email) VALUES ('%s','%s',%s,%s,'%s')",
                    emp.getNombre(), emp.getApellidos(), emp.getDepto().getIdDepartamento(), emp.getSalario(), emp.getEmail());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case DELETE:
                    sql = String.format("DELETE FROM empresa.empleados WHERE idEmpleado = (%s)", emp.getIdEmpleado());
                    resultadoQuery = sentence.execute(sql);
                    break;
                case MODIFY:
                    sql = String.format("UPDATE empresa.empleados SET Nombre=('%s'), Apellidos=('%s'),codDepartamento=(%s),Salario=(%s),Email=('%s') WHERE idEmpleado = (%s) ",
                    modificacion.getNombre(),modificacion.getApellidos(),modificacion.getDepto().getIdDepartamento(),modificacion.getSalario(),modificacion.getEmail(), modificacion.getIdEmpleado());
                    //Ejecutamos la sentencia
                    resultadoQuery = sentence.execute(sql);
                    break;
            }
            sentence.close();
            GDB.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(SQLEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoQuery;
    }

    public ManagerEmpleados listarEmpleados() {
        ManagerEmpleados listado = ME;
        ResultSet rs;
        //Conectar con la base de datos
        GDB.conectar();

        //Enviar la modificacion a la base de datos
        try {
            //Creamos la sentencia
            Statement sentence = GDB.conn.createStatement();
            // Y la syntax de la sentencia
            String sql = "SELECT * FROM empleados";
            //Ejecutar la consulta
            sentence.execute(sql);
            //Obtengo el resultset
            rs = sentence.getResultSet();

            while (rs.next()) {
                listado.add(new Empleado(rs.getInt(1),
                                         rs.getString(2),
                                         rs.getString(3),
                        new Departamento(rs.getInt(4), ""),
                                         rs.getFloat(5),
                                         rs.getString(6)));
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
