package com.asegurados.api.controller;


import com.asegurados.api.dto.DatosRequest;
import com.asegurados.api.dto.LiquidacionResponse;
import com.asegurados.api.service.LiquidacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("asegurado")
public class ApiController {

    private final LiquidacionService service;

    @PostMapping
    public LiquidacionResponse obtenerLiquidacion(@RequestBody @Valid DatosRequest datosRequest) {
        return service.obtenerLiquidacion(datosRequest);
    }
}
