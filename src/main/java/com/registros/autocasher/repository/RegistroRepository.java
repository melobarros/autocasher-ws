package com.registros.autocasher.repository;

import com.registros.autocasher.models.Registro;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RegistroRepository extends JpaRepository<Registro, Long> {
    Registro findById(long id);
    
    @Query("select r from Registro r where date_time between :startDate and :endDate")
    List<Registro> getRegistrosBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
}
