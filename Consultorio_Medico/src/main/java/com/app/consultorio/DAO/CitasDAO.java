
package com.app.consultorio.DAO;

import com.app.consultorio.Models.Citas;
import com.app.consultorio.Models.Medico;
import com.app.consultorio.Models.Paciente;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CitasDAO extends CrudRepository<Citas, Integer>{
    
    @Transactional(readOnly = true)
    @Query(value = "INSERT INTO citas (_paciente, _medico, descrip, fecha_registro,fecha_cita) VALUES (:id_paciente, :id_medico, :descrip, :fecha_registro, :fecha_cita);", nativeQuery = true)
    public Citas insertaCita(@Param("id_paciente") Paciente peciente, 
            @Param("id_medico") Medico medico, 
            @Param("descrip") String descrip, 
            @Param("fecha_registro") Date fecha_r, 
            @Param("fecha_cita") Date fecha_c );
}
