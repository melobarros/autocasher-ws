package com.registros.autocasher.resources;

import com.registros.autocasher.models.Manutencao;
import com.registros.autocasher.models.Registro;
import com.registros.autocasher.repository.RegistroRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Registros")
@CrossOrigin(origins="*")
public class RegistroResource {
    @Autowired
    RegistroRepository registroRepository;
    
    @GetMapping("/registros")
    @ApiOperation(value="Retorna a lista de todos os registros")
    public List<Registro> listaRegistros(){
        return registroRepository.findAll();
    }
    
    @GetMapping("/registro/{startDate}/{endDate}")
    @ApiOperation(value="Retorna a lista de todos os registros entre as datass de comeco e de fim")
    public List<Registro> listaRegistroEntreDatas(@PathVariable(value="startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, 
                                                            @PathVariable(value="endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {
        return registroRepository.getRegistrosBetweenDates(startDate, endDate);
    }
    
    @GetMapping("/registro/{id}")
    @ApiOperation(value="Retorna um registro baseado no id")
    public Registro listaRegistroUnico(@PathVariable(value="id") long id){
        return registroRepository.findById(id);
    }
}
