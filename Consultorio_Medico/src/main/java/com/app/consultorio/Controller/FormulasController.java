
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Formulas;
import com.app.consultorio.ServiceInterface.IFormulasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/formulas")
public class FormulasController {
    @Autowired
    private IFormulasService servicio;
    
    @PostMapping(value="/")
    public ResponseEntity<Formulas> agregar(@RequestBody Formulas formula){
        Formulas obj = servicio.save(formula);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Formulas> eliminar(@PathVariable Integer id){
        Formulas obj = servicio.findById(id);
        if(obj != null){
            servicio.delete(id);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
    @PutMapping(value="/")
    public ResponseEntity<Formulas> actualizar(@RequestBody Formulas form){
        Formulas obj = servicio.findById(form.getCod_formula());
        if(obj != null){
            obj.setCita(form.getCita());
            obj.setDescripcion(form.getDescripcion());
            obj.setMedicamentos_formulados(form.getMedicamentos_formulados());
            servicio.save(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Formulas> listar(){
        return servicio.findAll();
    }
    
    @GetMapping("/list/{id}")
    public Formulas consultar(@PathVariable Integer id){
        return servicio.findById(id);
    }
    
}
