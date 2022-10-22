
package com.app.consultorio.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table
@Entity(name = "formulas")
public class Formulas implements Serializable{
    @Id
    @Column(name = "cod_formula")
    private int cod_formula;
    @ManyToOne
    @JoinColumn(name = "cod_cita")
    private Citas cita;
    @Column(name = "medicamentos")
    private String medicamentos_formulados;
    @Column(name = "descrip_")
    private String descripcion;

    public Formulas(int cod_formula, Citas cita, String medicamentos_formulados, String descripcion) {
        this.cod_formula = cod_formula;
        this.cita = cita;
        this.medicamentos_formulados = medicamentos_formulados;
        this.descripcion = descripcion;
    }

    public Formulas() {
    }

    public int getCod_formula() {
        return cod_formula;
    }

    public void setCod_formula(int cod_formula) {
        this.cod_formula = cod_formula;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public String getMedicamentos_formulados() {
        return medicamentos_formulados;
    }

    public void setMedicamentos_formulados(String medicamentos_formulados) {
        this.medicamentos_formulados = medicamentos_formulados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
