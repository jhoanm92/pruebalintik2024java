package com.asegurados.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liquidacion {
    private Integer codigo_amparo;
    private String nombre_amparo;
    private Double valor_prima;
}
