
package com.app.consultorio.Service;

import com.app.consultorio.DAO.MedicoDAO;
import com.app.consultorio.Models.Medico;
import com.app.consultorio.ServiceInterface.IMedicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MedicoService implements IMedicoService{
    @Autowired
    private MedicoDAO dao;
    
    @Override
    @Transactional(readOnly = false)
    public Medico save(Medico medico) {
        return dao.save(medico);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Medico findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medico> findAll() {
        return (List<Medico>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean loginMedico(String usuario, String clave) {
        return dao.loginMedico(usuario, clave);
    }
    
}
