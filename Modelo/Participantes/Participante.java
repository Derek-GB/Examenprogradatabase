/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Participantes;

/**
 *
 * @author Student
 */
public class Participante {
    private String cedula;
    private String nombre;
    private String telefono;
    private String correo;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Participante(String cedula, String nombre, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Participante() {
        this("","","","");
    }

    @Override
    public String toString() {
        return "Participantes{" + "cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
    
    
    
    
    
    
}
