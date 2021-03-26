package com.registros.autocasher.repository;

import com.registros.autocasher.models.Lembrete;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LembreteRepository extends JpaRepository<Lembrete, Long>{
    Lembrete findById(long id);
    
    @Query("select l from Lembrete l where tipo = 'Lembrete' and date_time between :startDate and :endDate")
    List<Lembrete> getLembretesBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
