package com.registros.autocasher.repository;

import com.registros.autocasher.models.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    Manutencao findById(long id);
}
