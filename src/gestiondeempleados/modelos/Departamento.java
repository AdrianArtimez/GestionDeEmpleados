/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.modelos;

/**
 *
 * @author Adrián
 */
public class Departamento {

    private int idDepartamento;
    private String nombre;

    public Departamento() {
        idDepartamento = 0;
        nombre = "";
    }

    public Departamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;

    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento:" 
                + "\nid:" + idDepartamento 
                + "\nNombre:" + nombre;
    }

    
}
