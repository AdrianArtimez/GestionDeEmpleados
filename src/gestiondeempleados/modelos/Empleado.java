/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiondeempleados.modelos;

/**
 *
 * @author adria
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private Departamento depto;
    private float salario;
    private String email;

    public Empleado() {
        this.idEmpleado = 0;
        this.nombre = "";
        this.apellidos = "";
        this.depto = new Departamento();
        this.salario = 0.0f;
        this.email = "";
    }
    
    public Empleado(int idEmpleado, String nombre, String apellidos, Departamento depto, float salario, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.depto = depto;
        this.salario = salario;
        this.email = email;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Departamento getDepto() {
        return depto;
    }

    public float getSalario() {
        return salario;
    }

    public String getEmail() {
        return email;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
}
