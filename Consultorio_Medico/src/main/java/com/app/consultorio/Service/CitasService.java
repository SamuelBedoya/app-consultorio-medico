
package com.app.consultorio.Service;

import com.app.consultorio.DAO.CitasDAO;
import com.app.consultorio.Models.Citas;

import com.app.consultorio.ServiceInterface.ICitasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
public class CitasService implements ICitasService{
    @Autowired
    private CitasDAO daoCita;

    @Override
    @Transactional(readOnly = false)
    public Citas save(Citas cita) {
        return daoCita.save(cita);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        daoCita.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Citas findById(Integer id) {
        return daoCita.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Citas> findAll() {
        return (List<Citas>) daoCita.findAll();
    }
    
}
