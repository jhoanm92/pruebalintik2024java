package com.asegurados.api.dto;

import com.asegurados.api.util.Constantes;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DatosRequest {

    @NotNull
    private Integer tipo_identificacion;

    @NotNull
    private Integer nro_identificacion;

    @NotNull
    @Positive(message = Constantes.VALOR_ASEGURADO_NEGATIVO)
    private Integer valor_asegurado;

}
