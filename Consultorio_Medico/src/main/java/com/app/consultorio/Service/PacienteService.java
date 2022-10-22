
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
    public Paciente save(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> findAll() {
        return (List<Paciente>) dao.findAll();
    }

    @Override
    public Paciente loginPaciente(String usuario, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
