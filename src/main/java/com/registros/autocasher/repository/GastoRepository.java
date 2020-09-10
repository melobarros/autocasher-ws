package com.registros.autocasher.repository;

import com.registros.autocasher.models.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    Gasto findById(long id);
}
