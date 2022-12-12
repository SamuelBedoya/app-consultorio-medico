
package com.app.consultorio.ServiceInterface;

import com.app.consultorio.Models.Citas;

import java.util.List;

public interface ICitasService {
    public Citas save(Citas cita);
    public void delete(Integer id);
    public Citas findById(Integer id);
    public List<Citas> findAll();
    
}
