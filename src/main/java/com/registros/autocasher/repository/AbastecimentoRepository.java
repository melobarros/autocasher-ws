package com.registros.autocasher.repository;

import com.registros.autocasher.models.Abastecimento;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    Abastecimento findById(long id);
    
    //@Query("select a from Article a where a.creationDateTime <= :creationDateTime")
    //@Param("startDate") Date creationDateTime);
    @Query("select a from Abastecimento a where tipo = 'Abastecimento' and date_time between '2015-03-19' and '2018-03-19'")
    List<Abastecimento> getAbastecimentosBetweenDates();//@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
