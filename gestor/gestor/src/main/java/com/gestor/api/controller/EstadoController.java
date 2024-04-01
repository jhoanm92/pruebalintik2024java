package com.gestor.api.controller;

import com.gestor.api.entity.Estado;
import com.gestor.api.entity.Tarea;
import com.gestor.api.service.EstadoService;
import com.gestor.api.service.TareaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estados")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }
}
