package mx.com.telcel.incidencias.controller;

import mx.com.telcel.incidencias.bussines.IncidenciaService;
import mx.com.telcel.incidencias.model.entity.IncidenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/incidencia")
public class IncidenciaController {


    @Autowired
    IncidenciaService incidenciaService;

    @GetMapping(value = "/test")
    public String test(){
        return "Esto es una prueba test";
    }

    @PostMapping(value = "/createIncidencia")
    public ResponseEntity<Boolean> createIncidencia(@RequestBody IncidenciaEntity incidenciaRequest){
        Boolean resp = incidenciaService.createIncidencia(incidenciaRequest);
        return ResponseEntity.ok(resp);
    }

    @GetMapping(value="/getAllIncidencias")
    public List<IncidenciaEntity> getAllIncidencias() {
        return incidenciaService.getAllIncidencias();
    }

    @DeleteMapping(value = "/deleteIncidencia/{idIncidencia}")
    public Map<String, Boolean> deleteIncidencia(@PathVariable(value = "idIncidencia") Integer idIncidencia) {
        Map<String, Boolean> response = new HashMap<>();
        if (incidenciaService.deleteIncidencia(idIncidencia)) {
            response.put("DELETED", Boolean.TRUE);
        } else {
            response.put("ERROR", Boolean.FALSE);
        }
        return response;
    }

    @PutMapping(value = "/updateIncidencia")
    public IncidenciaEntity updateIncidencia(@RequestBody IncidenciaEntity incidencia) {
        return incidenciaService.updateIncidencia(incidencia);
    }
}
