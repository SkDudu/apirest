package com.api.apirest.repository;

import com.api.apirest.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoas, Long> {
    //Pessoas findAll(String monthAni);
    //Pessoas findByMonth(String month);
    //Pessoas findByName(String name);
}
