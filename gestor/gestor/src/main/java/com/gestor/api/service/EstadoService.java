package com.gestor.api.service;


import com.gestor.api.entity.Estado;

import java.util.List;

public interface EstadoService {

    List<Estado> obtenerTodos();

    Estado registrar(Estado estado);

    Estado actualizar(Estado estado);

    Estado obtenerPorId(Integer id);

    void eliminar(Integer id);
}
