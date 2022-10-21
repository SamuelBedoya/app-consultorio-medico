
package com.app.consultorio.DAO;

import com.app.consultorio.Models.Formulas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormulasDAO extends CrudRepository<Formulas, Integer>{
    
}
