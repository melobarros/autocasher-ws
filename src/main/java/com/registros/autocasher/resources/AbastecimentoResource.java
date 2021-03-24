package com.registros.autocasher.resources;

import com.registros.autocasher.models.Abastecimento;
import com.registros.autocasher.repository.AbastecimentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
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
@Api(value="API REST Abastecimentos")
@CrossOrigin(origins="*")
public class AbastecimentoResource {
    @Autowired
    AbastecimentoRepository abastecimentoRepository;
    
    @GetMapping("/registros/abastecimentos")
    @ApiOperation(value="Retorna a lista de todos os abastecimentos")
    public List<Abastecimento> listaAbastecimentos(){
        return abastecimentoRepository.findAll();
    }
    
    @GetMapping("/registro/abastecimento/{startDate}/{endDate}")
    @ApiOperation(value="Retorna a lista de todos os abastecimentos entre as datass de comeco e de fim")
    public List<Abastecimento> listaAbastecimentoEntreDatas(@PathVariable(value="startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, 
                                                            @PathVariable(value="endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {
        return abastecimentoRepository.getAbastecimentosBetweenDates(startDate, endDate);
    }
    
    @GetMapping("/registro/abastecimento/{id}")
    @ApiOperation(value="Retorna um abastecimento baseado no id")
    public Abastecimento listaAbastecimentoUnico(@PathVariable(value="id") long id){
        return abastecimentoRepository.findById(id);
    }
    
    @PostMapping("/registro/abastecimento")
    @ApiOperation(value="Salva um novo abastecimento")
    public Abastecimento salvaAbastecimento(@RequestBody Abastecimento abastecimento){
        return abastecimentoRepository.save(abastecimento);
    }
    
    @DeleteMapping("/registro/abastecimento")
    @ApiOperation(value="Deleta um abastecimento")
    public void deletaAbastecimento(@RequestBody Abastecimento abastecimento){
        abastecimentoRepository.delete(abastecimento);
    }
    
    @PutMapping("/registro/abastecimento")
    @ApiOperation(value="Atualiza um abastecimento")
    public Abastecimento atualizaAbastecimento(@RequestBody Abastecimento abastecimento){
        return abastecimentoRepository.save(abastecimento);
    }
}
