package com.asegurados.api.service;

import com.asegurados.api.dto.DatosRequest;
import com.asegurados.api.dto.LiquidacionResponse;

public interface LiquidacionService {

    LiquidacionResponse obtenerLiquidacion(DatosRequest datosRequest);
}
