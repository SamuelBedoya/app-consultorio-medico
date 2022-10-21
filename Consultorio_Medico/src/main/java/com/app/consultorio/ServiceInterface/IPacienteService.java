
package com.app.consultorio.ServiceInterface;

import com.app.consultorio.Models.Paciente;
import java.util.List;

public interface IPacienteService {
    public Paciente save(Paciente paciente);
    public void delete(Integer id);
    public Paciente findById(Integer id);
    public List<Paciente> findAll();
    public Paciente loginPaciente(String usuario, String clave);
    
}
