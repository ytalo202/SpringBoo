package com.example.demo.controller;

import com.example.demo.entity.Nota;
import com.example.demo.model.MNota;
import com.example.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PutMapping("/nota")
    public boolean agregarNota(@RequestBody @Valid Nota nota){
        return notaService.crear(nota);
    }


    @PostMapping("/nota")
    public boolean actualizarNota(@RequestBody @Valid Nota nota){
        return notaService.actualizar(nota);
    }

    @DeleteMapping("/nota/{id}/{nombre}")
    public boolean borrarNota(@PathVariable("id") Long id ,
                              @PathVariable("nombre") String nombre){
        return notaService.borrar(nombre,id);
    }

    @GetMapping("/nota")
    public List<MNota> obtenerNotas(){
        return notaService.obtener();
    }

    //http://localhost:8020/v1/notaPaginadas?page=0&size=5
    @GetMapping("/notaPaginadas")
    public List<MNota> obtenerNotas(Pageable pageable){
        return notaService.obtenerPorPaginacion(pageable);
    }
}
