package com.registros.autocasher.repository;

import com.registros.autocasher.models.Gasto;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    Gasto findById(long id);
    
    @Query("select g from Gasto g where tipo = 'Gasto' and date_time between :startDate and :endDate")
    List<Gasto> getGastosBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}

