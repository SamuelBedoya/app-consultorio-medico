
package com.app.consultorio.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table
@Entity(name = "medico")
public class Medico implements Serializable {
    @Id
    @Column(name="id_medico")
    private int id_medico;
    @Column(name ="cod_medico")
    private int identificacion;
    @Column(name ="nombre_medico")
    private String nombre;
    @Column(name = "apellido_medico")
    private String apellido;
    @Column(name = "ciudad_medico")
    private String ciudad;
    @Column(name = "direcc_medico")
    private String direccion;
    @Column(name = "tel_medico")
    private String telefono;
    @Column(name = "email_medico")
    private String email;
    @Column(name = "clave_medico")
    private String clave;
    @Column(name = "usuario_medico")
    private String usuario;
    @Column(name = "fecha_naci_medico")
    private Date f_nacimiento;

    public Medico(int id_medico, int identificacion, String nombre, String apellido, String ciudad, String direccion, String telefono, String email, String clave, String usuario,Date f_nacimiento) {
        this.id_medico = id_medico;
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

    public Medico() {
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
