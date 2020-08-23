package com.registros.autocasher.repository;

import com.registros.autocasher.models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistroRepository extends JpaRepository<Registro, Long> {
    Registro findById(long id);
}
