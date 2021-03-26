package com.registros.autocasher.repository;

import com.registros.autocasher.models.Manutencao;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    Manutencao findById(long id);
    
    @Query("select m from Manutencao m where tipo = 'Manutencao' and date_time between :startDate and :endDate")
    List<Manutencao> getManutencoesBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
