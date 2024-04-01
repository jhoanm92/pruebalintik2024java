package com.gestor.api.service.impl;

import com.gestor.api.entity.Proyecto;
import com.gestor.api.exception.ModeloNotFoundException;
import com.gestor.api.repository.ProyectoRepository;
import com.gestor.api.service.ProyectoService;
import com.gestor.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository repository;

    @Override
    public List<Proyecto> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Proyecto registrar(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    @Override
    public Proyecto actualizar(Proyecto proyecto) {
        this.obtenerPorId(proyecto.getId());
        return repository.save(proyecto);
    }

    @Override
    public Proyecto obtenerPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ModeloNotFoundException(Constantes.ID_NO_ENCONTRADO + id));
    }

    @Override
    public void eliminar(Integer id) {
        this.obtenerPorId(id);
        repository.deleteById(id);
    }
}
