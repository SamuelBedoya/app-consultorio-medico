
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Medico;
import com.app.consultorio.ServiceInterface.IMedicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    private IMedicoService service;
    
    @GetMapping("/list")
    public List<Medico> listar(){
        return service.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Medico consultar(@PathVariable Integer id){
        return service.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Medico> agregar(@RequestBody Medico paciente){
        Medico obj = service.save(paciente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Medico> eliminar(@PathVariable Integer id){
        Medico obj = service.findById(id);
        if(obj != null){
            service.delete(id);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @PutMapping(value="/")
    public ResponseEntity<Medico> editar(@RequestBody Medico pa){
        Medico obj = service.findById(pa.getId_medico());
        if(obj != null){
            obj.setNombre(pa.getNombre());
            obj.setApellido(pa.getApellido());
            obj.setCiudad(pa.getCiudad());
            obj.setDireccion(pa.getDireccion());
            obj.setF_nacimiento(pa.getF_nacimiento());
            obj.setTelefono(pa.getTelefono());
            obj.setUsuario(pa.getUsuario());
            obj.setClave(pa.getClave());
            obj.setEmail(pa.getEmail());
            obj.setIdentificacion(pa.getIdentificacion());
            service.save(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
}
