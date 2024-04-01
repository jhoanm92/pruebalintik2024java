package com.asegurados.api.repository;

import com.asegurados.api.dto.DatosRequest;
import com.asegurados.api.entity.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AseguradoRepository extends JpaRepository<Asegurado, Integer> {
    @Query("select a from Asegurado a where a.tipoDocumento.id = :#{#datosRequest.tipo_identificacion} and a.numeroIdentificacion = :#{#datosRequest.nro_identificacion}")
    Optional<Asegurado> obtenerAsegurado(@Param("datosRequest") DatosRequest datosRequest);

}