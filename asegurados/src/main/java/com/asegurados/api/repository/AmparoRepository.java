package com.asegurados.api.repository;

import com.asegurados.api.entity.Amparo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmparoRepository extends JpaRepository<Amparo, Integer> {
}