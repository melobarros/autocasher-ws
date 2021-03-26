package com.registros.autocasher.resources;

import com.registros.autocasher.models.Gasto;
import com.registros.autocasher.models.Lembrete;
import com.registros.autocasher.repository.LembreteRepository;
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
@Api(value="API REST Lembretes")
@CrossOrigin(origins="*")
public class LembreteResource{
    @Autowired
    LembreteRepository lembreteRepository;
    
    @GetMapping("/registros/lembretes")
    @ApiOperation(value="Retorna a lista de todos os lembretes")
    public List<Lembrete> listaLembretes(){
        return lembreteRepository.findAll();
    }
    
    @GetMapping("/registro/lembrete/{startDate}/{endDate}")
    @ApiOperation(value="Retorna a lista de todos os lembretes entre as datass de comeco e de fim")
    public List<Lembrete> listaLembreteEntreDatas(@PathVariable(value="startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, 
                                                            @PathVariable(value="endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {
        return lembreteRepository.getLembretesBetweenDates(startDate, endDate);
    }
    
    @GetMapping("/registro/lembrete/{id}")
    @ApiOperation(value="Retorna um lembrete baseado no id")
    public Lembrete listaLembreteUnico(@PathVariable(value="id") long id){
        return lembreteRepository.findById(id);
    }
    
    @PostMapping("/registro/lembrete")
    @ApiOperation(value="Salva um novo lembrete")
    public Lembrete salvaLembrete(@RequestBody Lembrete lembrete){
        return lembreteRepository.save(lembrete);
    }
    
    @DeleteMapping("/registro/lembrete")
    @ApiOperation(value="Deleta um lembrete")
    public void deletaLembrete(@RequestBody Lembrete lembrete){
        lembreteRepository.delete(lembrete);
    }
    
    @PutMapping("/registro/lembrete")
    @ApiOperation(value="Atualiza um lembrete")
    public Lembrete atualizaLembrete(@RequestBody Lembrete lembrete){
        return lembreteRepository.save(lembrete);
    }
}
