package com.asegurados.api.repository;

import com.asegurados.api.entity.Prima;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaRepository extends JpaRepository<Prima, Integer> {
}