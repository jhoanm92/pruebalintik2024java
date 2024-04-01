package com.gestor.api.service.impl;

import com.gestor.api.entity.Tarea;
import com.gestor.api.entity.Tarea;
import com.gestor.api.exception.ModeloNotFoundException;
import com.gestor.api.repository.EstadoRepository;
import com.gestor.api.repository.TareaRepository;
import com.gestor.api.service.TareaService;
import com.gestor.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService {

    private final TareaRepository repository;

    @Override
    public List<Tarea> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Tarea registrar(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    public Tarea actualizar(Tarea tarea) {
        this.obtenerPorId(tarea.getId());
        return repository.save(tarea);
    }

    @Override
    public Tarea obtenerPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ModeloNotFoundException(Constantes.ID_NO_ENCONTRADO + id));
    }

    @Override
    public void eliminar(Integer id) {
        this.obtenerPorId(id);
        repository.deleteById(id);
    }
}
