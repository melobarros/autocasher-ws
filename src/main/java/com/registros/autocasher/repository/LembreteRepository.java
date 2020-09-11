package com.registros.autocasher.repository;

import com.registros.autocasher.models.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembrete, Long>{
    Lembrete findById(long id);
}
