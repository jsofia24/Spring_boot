package com.personalproject.tasks1.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
    // Como vamos a trabajar con Hibernate, nos exige que la 
    // clase tenga un valor indicativo:
    
    // Id de la entidad (Será la llave primaria)
    @Id
    // ME permite de manera automatica general valores
    // para un atributo
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus; 

}
