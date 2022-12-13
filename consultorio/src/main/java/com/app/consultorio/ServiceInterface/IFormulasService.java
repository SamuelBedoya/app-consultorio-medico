
package com.app.consultorio.ServiceInterface;

import com.app.consultorio.Models.Formulas;
import java.util.List;

public interface IFormulasService {
    public Formulas save(Formulas cita);
    public void delete(Integer id);
    public Formulas findById(Integer id);
    public List<Formulas> findAll();
    
}
