package com.gestor.api.service;


import com.gestor.api.entity.Tarea;

import java.util.List;

public interface TareaService  {

    
    List<Tarea> obtenerTodos();
    
    Tarea registrar(Tarea tarea);
    
    Tarea actualizar(Tarea tarea);
    
    Tarea obtenerPorId(Integer id);

    void eliminar(Integer id);
}
