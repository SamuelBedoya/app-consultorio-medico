
package com.app.consultorio.ServiceInterface;

import com.app.consultorio.Models.Medico;
import java.util.List;

public interface IMedicoService {
    public Medico save(Medico medico);
    public void delete(Integer id);
    public Medico findById(Integer id);
    public List<Medico> findAll();
    public boolean loginMedico(String usuario,String clave);
    
}
