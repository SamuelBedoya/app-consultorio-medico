
package com.app.consultorio.DAO;

import com.app.consultorio.Models.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PacienteDAO extends CrudRepository<Paciente, Integer>{
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM paciente WHERE usuario_paciente = :usuario AND clave_paciente = :clave", nativeQuery = true)
    public Paciente loginPaciente(@Param("usuario") String usuario, @Param("clave") String clave);
    
}
