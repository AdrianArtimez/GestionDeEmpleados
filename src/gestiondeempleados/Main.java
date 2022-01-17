/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiondeempleados;

import gestiondeempleados.modelos.Departamento;
import gestiondeempleados.db.GestionDB;
import gestiondeempleados.db.GestionDepartamento;

/**
 *
 * @author adria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionDB conn = new GestionDB("userdb","1234","localhost","empresa");
        GestionDepartamento gd = new GestionDepartamento();       
        ManagerDepartamentos md = new ManagerDepartamentos();   
        
        md = gd.listarDepartamentos();
        
        System.out.println(md.toString());
    }
    
}
