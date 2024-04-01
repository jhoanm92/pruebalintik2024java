package com.gestor.api.controller;

import com.gestor.api.entity.Tarea;
import com.gestor.api.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tareas")
@RequiredArgsConstructor
public class TareaController {
    
    private final TareaService service;

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }


    @PostMapping
    public ResponseEntity<Tarea> registrar(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(service.registrar(tarea));
    }

    @PutMapping
    public ResponseEntity<Tarea> actualizar(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(service.actualizar(tarea));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
