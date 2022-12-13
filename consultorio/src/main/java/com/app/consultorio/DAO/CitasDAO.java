
package com.app.consultorio.DAO;

import java.util.List;
import com.app.consultorio.Models.Citas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CitasDAO extends CrudRepository<Citas, Integer>{

    @Transactional(readOnly=true)//No afecta integridad base de datos
    @Query(value="SELECT * FROM citas WHERE _paciente = :idp", nativeQuery=true)
    public List<Citas> consulta_citas(@Param("idp") Integer idp); 
    
}
