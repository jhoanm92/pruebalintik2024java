package com.asegurados.api.repository;

import com.asegurados.api.entity.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexoRepository extends JpaRepository<Sexo, Integer> {
}