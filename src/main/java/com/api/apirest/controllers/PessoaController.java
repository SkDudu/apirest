package com.api.apirest.controllers;

import com.api.apirest.models.Pessoas;
import com.api.apirest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    //Listar todos
    @GetMapping
    public List<Pessoas> listar(){
        return pessoaRepository.findAll();
    }

    //Encontar 1 pelo ID
    @GetMapping("/pessoas/{id}")
    Optional<Pessoas> one(@PathVariable Long id) {
        return pessoaRepository.findById(id);
    }

    //Encontrar pelo dia
    //@GetMapping("/pessoas/{dateAni}")
    //Optional<Pessoas> one(@PathVariable String dateAni) {
    //    return pessoaRepository.findOne();
    //}

    //Encontrar pelo mês
    //@GetMapping("/pessoas/{dateAni}")
    //Optional<Pessoas> one(@PathVariable String dateAni) {
    //    return pessoaRepository.findOne();
    //}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoas adicionarPessoas(@RequestBody Pessoas pessoas){
        return pessoaRepository.save(pessoas);
    }

    @DeleteMapping("/{id}")
    void deletePessoas(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}
