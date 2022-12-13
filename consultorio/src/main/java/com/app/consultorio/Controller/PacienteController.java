
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Paciente;
import com.app.consultorio.ServiceInterface.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.consultorio.Security.Hash;

@RestController
@CrossOrigin("*")
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private IPacienteService service;
    
    @GetMapping("/list")
    public List<Paciente> listar(){
        return service.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Paciente consultar(@PathVariable Integer id){
        return service.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Paciente> agregar(@RequestBody Paciente paciente){
        Paciente obj = service.save(paciente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable Integer id){
        Paciente obj = service.findById(id);
        if(obj != null){
            service.delete(id);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @PutMapping(value="/")
    public ResponseEntity<Paciente> editar(@RequestBody Paciente pa){
        Paciente obj = service.findById(pa.getId_paciente());
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
            
    @GetMapping("/login")
    @ResponseBody
    public Paciente ingresar(@RequestParam String usuario,@RequestParam String clave) {
        //clave=Hash.sha1(clave);
        return service.loginPaciente(usuario, clave); 
    }
    
}
