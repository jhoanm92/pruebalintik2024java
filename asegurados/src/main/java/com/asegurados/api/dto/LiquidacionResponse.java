package com.asegurados.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class LiquidacionResponse {

    private Integer tipo_identificacion;
    private Integer nro_identificacion;
    private Integer valor_asegurado;
    private Double Valor_total;
    private List<Liquidacion> liquidacion;

}
