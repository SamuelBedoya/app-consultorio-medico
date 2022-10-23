
package com.app.consultorio.DAO;

import com.app.consultorio.Models.Citas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasDAO extends CrudRepository<Citas, Integer>{
    
}
