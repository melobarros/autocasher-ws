package com.registros.autocasher.resources;

import com.registros.autocasher.models.Lembrete;
import com.registros.autocasher.models.Manutencao;
import com.registros.autocasher.repository.ManutencaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api")
@Api(value="API REST Manutencoes")
@CrossOrigin(origins="*")
public class ManutencaoResource {
    @Autowired
    ManutencaoRepository manutencaoRepository;

    @GetMapping("/registros/manutencoes")
    @ApiOperation(value="Retorna a lista de todos os manutencoes")
    public List<Manutencao> listaManutencaos(){
        return manutencaoRepository.findAll();
    }

    @GetMapping("/registro/manutencao/{startDate}/{endDate}")
    @ApiOperation(value="Retorna a lista de todas as manutencoes entre as datass de comeco e de fim")
    public List<Manutencao> listaManutencaoEntreDatas(@PathVariable(value="startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, 
                                                            @PathVariable(value="endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {
        return manutencaoRepository.getManutencoesBetweenDates(startDate, endDate);
    }
    
    @GetMapping("/registro/manutencao/{id}")
    @ApiOperation(value="Retorna um manutencao baseado no id")
    public Manutencao listaManutencaoUnico(@PathVariable(value="id") long id){
        return manutencaoRepository.findById(id);
    }

    @PostMapping("/registro/manutencao")
    @ApiOperation(value="Salva um novo manutencao")
    public Manutencao salvaManutencao(@RequestBody Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    @DeleteMapping("/registro/manutencao")
    @ApiOperation(value="Deleta um manutencao")
    public void deletaManutencao(@RequestBody Manutencao manutencao){
        manutencaoRepository.delete(manutencao);
    }

    @PutMapping("/registro/manutencao")
    @ApiOperation(value="Atualiza um manutencao")
    public Manutencao atualizaManutencao(@RequestBody Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }
}
