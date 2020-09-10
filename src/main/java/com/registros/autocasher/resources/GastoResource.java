package com.registros.autocasher.resources;

import com.registros.autocasher.models.Abastecimento;
import com.registros.autocasher.models.Gasto;
import com.registros.autocasher.repository.GastoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value="API REST Gastos")
@CrossOrigin(origins="*")
public class GastoResource {
    @Autowired
    GastoRepository gastoRepository;
    
    @GetMapping("/registros/gastos")
    @ApiOperation(value="Retorna a lista de todos os gastos")
    public List<Gasto> listaGastos(){
        return gastoRepository.findAll();
    }
    
    @GetMapping("/registro/gasto/{id}")
    @ApiOperation(value="Retorna um gasto baseado no id")
    public Gasto listaGastoUnico(@PathVariable(value="id") long id){
        return gastoRepository.findById(id);
    }
    
    @PostMapping("/registro/gasto")
    @ApiOperation(value="Salva um novo gasto")
    public Gasto salvaAbastecimento(@RequestBody Gasto gasto){
        return gastoRepository.save(gasto);
    }
    
    @DeleteMapping("/registro/gasto")
    @ApiOperation(value="Deleta um gasto")
    public void deletaGasto(@RequestBody Gasto gasto){
        gastoRepository.delete(gasto);
    }
    
    @PutMapping("/registro/gasto")
    @ApiOperation(value="Atualiza um gasto")
    public Gasto atualizaGasto(@RequestBody Gasto gasto){
        return gastoRepository.save(gasto);
    }
}
