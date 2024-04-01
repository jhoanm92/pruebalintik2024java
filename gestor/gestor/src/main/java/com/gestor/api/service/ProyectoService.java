package com.gestor.api.service;


import com.gestor.api.entity.Proyecto;

import java.util.List;

public interface ProyectoService  {

    List<Proyecto> obtenerTodos();

    Proyecto registrar(Proyecto proyecto);

    Proyecto actualizar(Proyecto proyecto);

    Proyecto obtenerPorId(Integer id);

    void eliminar(Integer id);
}
