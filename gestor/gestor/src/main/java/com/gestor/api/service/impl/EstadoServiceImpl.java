package com.gestor.api.service.impl;

import com.gestor.api.entity.Estado;
import com.gestor.api.exception.ModeloNotFoundException;
import com.gestor.api.repository.EstadoRepository;
import com.gestor.api.service.EstadoService;
import com.gestor.api.util.Constantes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository repository;

    @Override
    public List<Estado> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Estado registrar(Estado estado) {
        return repository.save(estado);
    }

    @Override
    public Estado actualizar(Estado estado) {
        this.obtenerPorId(estado.getId());
        return repository.save(estado);
    }

    @Override
    public Estado obtenerPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ModeloNotFoundException(Constantes.ID_NO_ENCONTRADO + id));
    }

    @Override
    public void eliminar(Integer id) {
        this.obtenerPorId(id);
        repository.deleteById(id);
    }
}
