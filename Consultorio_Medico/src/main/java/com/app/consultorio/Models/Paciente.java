
package com.app.consultorio.Models;


import java.io.Serializable;
import javax.persistence.*;

@Table
@Entity(name = "paciente")
public class Paciente implements Serializable {
    @Id
    @Column(name="id_paciente")
    private int id_paciente;
    @Column(name ="cod_paciente")
    private int identificacion;
    @Column(name ="nombre_paciente")
    private String nombre;
    @Column(name = "apellido_paciente")
    private String apellido;
    @Column(name = "ciudad_paciente")
    private String ciudad;
    @Column(name = "direcc_paciente")
    private String direccion;
    @Column(name = "tel_paciente")
    private String telefono;
    @Column(name = "email_paciente")
    private String email;
    @Column(name = "clave_paciente")
    private String clave;
    @Column(name = "usuario_paciente")
    private String usuario;
    @Column(name = "fecha_naci_paciente")
    private String f_nacimiento;

    public Paciente(int id_paciente, int identificacion, String nombre, String apellido, String ciudad, String direccion, String telefono, String email, String clave,String usuario, String f_nacimiento) {
        this.id_paciente = id_paciente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.f_nacimiento = f_nacimiento;
        this.usuario = usuario;
    }

    public Paciente() {
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
