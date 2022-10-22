
package com.app.consultorio.Service;

import com.app.consultorio.DAO.CitasDAO;
import com.app.consultorio.Models.Citas;
import com.app.consultorio.Models.Medico;
import com.app.consultorio.Models.Paciente;
import com.app.consultorio.ServiceInterface.ICitasService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
public class CitasService implements ICitasService{
    @Autowired
    private CitasDAO daoCita;

    @Override
    public Citas save(Citas cita) {
        return daoCita.save(cita);
    }

    @Override
    public void delete(Integer id) {
        daoCita.deleteById(id);
    }

    @Override
    public Citas findById(Integer id) {
        return daoCita.findById(id).orElse(null);
    }

    @Override
    public List<Citas> findAll() {
        return (List<Citas>) daoCita.findAll();
    }

    @Override
    public Citas add(Paciente paciente, Medico medico, String descrip, Date fecha_r, Date fecha_c) {
        return daoCita.insertaCita(paciente, medico, descrip, fecha_r, fecha_c);
    }
    
}
