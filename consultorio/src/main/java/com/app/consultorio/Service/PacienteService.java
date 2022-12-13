
package com.app.consultorio.Service;

import com.app.consultorio.DAO.PacienteDAO;
import com.app.consultorio.Models.Paciente;
import com.app.consultorio.ServiceInterface.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private PacienteDAO dao;

    @Override
    @Transactional(readOnly = false)
    public Paciente save(Paciente paciente) {
        return dao.save(paciente);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findById(Integer id) {
       return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return (List<Paciente>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente loginPaciente(String usuario, String clave) {
       return dao.loginPaciente(usuario, clave);
    }
    
}
