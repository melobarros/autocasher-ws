package com.registros.autocasher.repository;

import com.registros.autocasher.models.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    Abastecimento findById(long id);
}
