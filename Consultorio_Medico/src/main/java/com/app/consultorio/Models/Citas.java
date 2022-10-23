
package com.app.consultorio.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table
@Entity(name="citas")
public class Citas implements Serializable{
    @Id
    @Column(name = "cod_cita")
    private int cod_cita;
    @ManyToOne
    @JoinColumn(name = "_paciente")
    private Paciente id_paciente;
    @ManyToOne
    @JoinColumn(name = "_medico")
    private Medico id_medico;
    @Column(name = "descrip")
    private String descripcion;
    @Column(name = "fecha_cita")
    private String fecha_registro;
    /*@Column(name = "fecha_cita")
    private Date fecha_cita;*/

    public Citas(int cod_cita, Paciente id_paciente, Medico id_medico, String descripcion, String fecha) {
        this.cod_cita = cod_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.descripcion = descripcion;
        this.fecha_registro = fecha;
        /*this.fecha_cita = fecha_cita;*/
    }

    public Citas() {
    }

    public int getCod_cita() {
        return cod_cita;
    }

    public void setCod_cita(int cod_cita) {
        this.cod_cita = cod_cita;
    }

    public Paciente getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Paciente id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Medico getId_medico() {
        return id_medico;
    }

    public void setId_medico(Medico id_medico) {
        this.id_medico = id_medico;
    }

    public String getDecripcion() {
        return descripcion;
    }

    public void setDecripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        
    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
/*
    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }
    */

}
