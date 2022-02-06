/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.logica;

import gestiondeempleados.db.sql.SQLEmpleado;
import gestiondeempleados.enums.QType;
import gestiondeempleados.logica.ManagerEmpleados;
import gestiondeempleados.modelos.Empleado;


/**
 *
 * @author adria
 */
public class GestionHelper {

    SQLEmpleado GH = new SQLEmpleado();
    
    public boolean insertarEmpleado(Empleado emp) {
        return GH.empleadoQuery(emp, null, QType.NEW);
    }

    //Borrar empleado
    public boolean eliminarEmpleado(Empleado emp) {
        return GH.empleadoQuery(emp, null, QType.DELETE);
    }

    public boolean modificarEmpleado(Empleado emp, Empleado newEmp) {
        return GH.empleadoQuery(emp, newEmp, QType.MODIFY);
    }
    
    public ManagerEmpleados listarEmpleados() {
        return GH.listarEmpleados();

    }

}
