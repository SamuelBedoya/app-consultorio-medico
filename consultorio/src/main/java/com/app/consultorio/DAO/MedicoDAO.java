
package com.app.consultorio.DAO;

import com.app.consultorio.Models.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicoDAO extends CrudRepository<Medico, Integer>{
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM medico WHERE usuario_medico = :usuario AND clave_medico = :clave", nativeQuery = true)
    public boolean loginMedico(@Param("usuario") String usuario, @Param("clave") String clave);
    
}
