package com.api.apirest.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;
    private String dateAni;
    private String monthAni;

    //@Column(name = "date")
    //private String dateAni;

    //@Column(name = "month")
    //private String monthAni;


}
