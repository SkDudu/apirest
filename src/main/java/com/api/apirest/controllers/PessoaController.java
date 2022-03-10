package com.api.apirest.controllers;

import com.api.apirest.models.Pessoas;
import com.api.apirest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    Optional<Pessoas> one(@PathVariable("id") Long id) {
        return pessoaRepository.findById(id);
    }

    //Encontrar pelo dia
    //@GetMapping("/pessoas/{dateAni}")
    //Optional<Pessoas> one(@PathVariable("id") Long id) {
    //    return pessoaRepository.findAll();
    //}

    //Encontrar pelo mês
    //@GetMapping("/pessoas/{dateAni}")
    //Optional<Pessoas> one(@PathVariable String dateAni) {
    //    return pessoaRepository.findOne();
    //} Sort.by("published").descending()

    //@PostMapping("/pesquisar/{monthAni}")
    //public Pessoas pesquisarPessoas(String monthAni) {
    //    return pessoaRepository.findAll(monthAni);
    //}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoas adicionarPessoas(@RequestBody Pessoas pessoas){
        return pessoaRepository.save(pessoas);
    }

    @GetMapping("/pessoas/month")
    public List<Pessoas> ordenarPessoas(){
        return pessoaRepository.findAll(Sort.by("pessoas").descending());
    }

    //@GetMapping("/pessoas/month")
    //public List<Pessoas> findByMonth(String month){
    //        return pessoaRepository.findByMonth(month);
    //}

    @DeleteMapping("/pessoas/{id}")
    void deletePessoas(@PathVariable("id") Long id) {
        pessoaRepository.deleteById(id);
    }
}
