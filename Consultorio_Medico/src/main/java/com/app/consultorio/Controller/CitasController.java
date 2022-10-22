
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Citas;
import com.app.consultorio.ServiceInterface.ICitasService;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

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
    
    @GetMapping("list/{id}")
    public Citas consultar(@PathVariable Integer id){
        return citaService.findById(id);
    }
    
    @PostMapping(value="/")
    public ResponseEntity<Citas> agregarCita(@RequestBody Citas cita){
        Citas obj = citaService.add(cita.getId_paciente(),cita.getId_medico(),cita.getDecripcion(),cita.getFecha_registro(),cita.getFecha_cita());
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
    
   
}
