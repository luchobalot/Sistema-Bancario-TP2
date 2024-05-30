package ar.edu.utn.frbb.tup.model;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private Long dni;
    private String direccion;
    private long telefono;
    protected LocalDate fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getDni() {
        return dni;
    }

     public void setDni(Long dni) {
        this.dni = dni;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;

    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public long getTelefono() {
        return telefono;
    }
   

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

