package com.gestor.api.controller;

import com.gestor.api.entity.Proyecto;
import com.gestor.api.service.ProyectoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("proyectos")
@RequiredArgsConstructor
public class ProyectoController {
    
    private final ProyectoService service;

    @GetMapping
    public ResponseEntity<List<Proyecto>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }


    @PostMapping
    public ResponseEntity<Proyecto> registrar(@RequestBody Proyecto proyecto) {
        return ResponseEntity.ok(service.registrar(proyecto));
    }

    @PutMapping
    public ResponseEntity<Proyecto> actualizar(@RequestBody Proyecto proyecto) {
        return ResponseEntity.ok(service.actualizar(proyecto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
