
package com.app.consultorio.Service;

import com.app.consultorio.DAO.FormulasDAO;
import com.app.consultorio.Models.Formulas;
import com.app.consultorio.ServiceInterface.IFormulasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FormulasService implements IFormulasService{
    @Autowired
    private FormulasDAO dao;

    @Override
    @Transactional(readOnly = false)
    public Formulas save(Formulas cita) {
        return dao.save(cita);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Formulas findById(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Formulas> findAll() {
        return (List<Formulas>) dao.findAll();
    }
    
}
