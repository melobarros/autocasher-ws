package com.registros.autocasher.resources;

import com.registros.autocasher.models.Registro;
import com.registros.autocasher.repository.RegistroRepository;
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
    
    @GetMapping("/registro/{id}")
    @ApiOperation(value="Retorna um registro baseado no id")
    public Registro listaRegistroUnico(@PathVariable(value="id") long id){
        return registroRepository.findById(id);
    }
    
    @PostMapping("/registro")
    @ApiOperation(value="Salva um novo registro")
    public Registro salvaRegistro(@RequestBody Registro registro){
        return registroRepository.save(registro);
    }
    
    @DeleteMapping("/registro")
    @ApiOperation(value="Deleta um registro")
    public void deletaRegistro(@RequestBody Registro registro){
        registroRepository.delete(registro);
    }
    
    @PutMapping("/registro")
    @ApiOperation(value="Atualiza um registro")
    public Registro atualizaRegistro(@RequestBody Registro registro){
        return registroRepository.save(registro);
    }
}
