package com.asegurados.api.service.impl;

import com.asegurados.api.dto.DatosRequest;
import com.asegurados.api.dto.Liquidacion;
import com.asegurados.api.dto.LiquidacionResponse;
import com.asegurados.api.entity.Amparo;
import com.asegurados.api.entity.Asegurado;
import com.asegurados.api.entity.Prima;
import com.asegurados.api.exception.ModeloNotFoundException;
import com.asegurados.api.exception.ValidationException;
import com.asegurados.api.repository.AmparoRepository;
import com.asegurados.api.repository.AseguradoRepository;
import com.asegurados.api.repository.PrimaRepository;
import com.asegurados.api.service.LiquidacionService;
import com.asegurados.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class LiquidacionServiceImpl implements LiquidacionService {

    private final AseguradoRepository aseguradoRepository;
    private final PrimaRepository primaRepository;
    private final AmparoRepository amparoRepository;
    @Override
    public LiquidacionResponse obtenerLiquidacion(DatosRequest datosRequest) {

        Asegurado asegurado = aseguradoRepository.obtenerAsegurado(datosRequest).orElseThrow(() -> new ModeloNotFoundException(Constantes.ASEGURADO_NO_ENCNTRADO));

        List<Liquidacion> liquidaciones = new ArrayList<>();
        List<Prima> primas = primaRepository.findAll();
        List<Amparo> amparos = amparoRepository.findAll();
        int edad = Period.between(asegurado.getFechaNacimiento(), LocalDate.now()).getYears();

//        Tener los valores en memoria y no ir a DB a consultarlos en cada iteracion
        Map<Integer, String> amparoMap = new HashMap<>();
        for (Amparo am : amparos) {
            amparoMap.put(am.getId(), am.getNombre());
        }

//        Se iteran todas las primas y se compara la edad para agregar las que cumplan la condicion en una lista
        for ( Prima p: primas ) {
            if (edad >= p.getEdadMinima() && edad <= p.getEdadMaxima() ) {
                liquidaciones.add(new Liquidacion(
                        p.getCodigoAmparo().getId(),
                        amparoMap.get(p.getCodigoAmparo().getId()),
                        this.obtenerValorPrima(datosRequest.getValor_asegurado(), p.getPorcentaje())));
            }
        }

        LiquidacionResponse response = new LiquidacionResponse();
        response.setTipo_identificacion(datosRequest.getTipo_identificacion());
        response.setNro_identificacion(datosRequest.getNro_identificacion());
        response.setValor_asegurado(datosRequest.getValor_asegurado());

        response.setLiquidacion(liquidaciones);

        response.setValor_total(obtenerValorTotal(response));

        return response;
    }

    /**
     * Metodo para obtener el resultado de la multiplicaion entre el valor asegurado y el porcentaje
     * @param valor
     * @param porcentaje
     * @return
     */
    private Double obtenerValorPrima(Integer valor, Double porcentaje) {
        return valor * porcentaje;
    }

    /**
     * Metodo para obtener el valor total de la poliza que es la suma entre el valor asegurado y cada uno de los valores de la liquidacion
     * @param liquidacionResponse
     * @return
     */
    private Double obtenerValorTotal(LiquidacionResponse liquidacionResponse) {
        double totalLiquidacion = 0;
        for (Liquidacion l :liquidacionResponse.getLiquidacion() ) {
            totalLiquidacion += l.getValor_prima();
        }

        return liquidacionResponse.getValor_asegurado() + totalLiquidacion;
    }
}
