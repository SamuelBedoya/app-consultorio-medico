
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Citas;
import com.app.consultorio.ServiceInterface.ICitasService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/citas")
public class CitasController {
    @Autowired
    private ICitasService citaService;
    
    @GetMapping("/list")
    public List<Citas> listar(){
        return citaService.findAll();
    }

    // @GetMapping("/consulta")
    // @ResponseBody
    // public ResponseEntity<List<Citas>> consulta_cuenta(@RequestParam Integer idp) { 
    //     List<Citas> obj =  citaService.consulta_citas(idp);
    //     return new ResponseEntity<>(obj, HttpStatus.OK);
    // }

    @GetMapping("/consulta")
    @ResponseBody
    public List<Citas> consulta_cuenta(@RequestParam Integer idp) { 
        return citaService.consulta_citas(idp);
    }
    
    @GetMapping("list/{id}")
    public Citas consultar(@PathVariable Integer id){
        return citaService.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Citas> agregarCita(@RequestBody Citas cita){
        Citas obj = citaService.save(cita);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Citas> eliminar(@PathVariable Integer id){
       Citas obj = citaService.findById(id);
       if(obj != null){
           citaService.delete(id);
       }else{
           return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
       }
       return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Citas> editar(@RequestBody Citas cita){
        Citas obj = citaService.findById(cita.getCod_cita());
        if(obj != null){
            obj.setId_medico(cita.getId_medico());
            obj.setId_paciente(cita.getId_paciente());
            obj.setFecha_registro(cita.getFecha_registro());
            obj.setDecripcion(cita.getDecripcion());
            citaService.save(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
   
}
