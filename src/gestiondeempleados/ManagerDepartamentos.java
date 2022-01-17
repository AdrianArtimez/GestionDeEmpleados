/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados;

import gestiondeempleados.modelos.Departamento;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class ManagerDepartamentos {
    
    private ArrayList<Departamento> listaDept;
    
    public ManagerDepartamentos() {
        listaDept = new ArrayList<Departamento>();       
    }
    
    public boolean addDepartamento(Departamento dept) {       
        return listaDept.add(dept);
    }
    
    public boolean removeDepartamento(Departamento dept) {
        return listaDept.remove(dept);
    }
    
    /**
     * buscarDeparatamento method. 
     * @param nombre
     * @return Departamento if found. if not return a null dept.
     */
    public Departamento buscarDeparatamento(String nombre) {
        
        Departamento dept = null;
        
        for (int i = 0; i < listaDept.size(); i++) {
            if(listaDept.get(i).getNombre().equals(nombre)) {
                dept = listaDept.get(i);
            }
        }
        if(dept == null) {
            System.out.println("El departamento no se encontró");
        }
        return dept;
    }
    
    public Departamento buscarDeparatamento(int id) {
        
        Departamento dept = null;
        
        for (int i = 0; i < listaDept.size(); i++) {
            if(listaDept.get(i).getIdDepartamento() == id) {
                dept = listaDept.get(i);
            } else {
                System.out.println("Departamento no encontrado");
            }
        }
        return dept;
    }
    
    
}
