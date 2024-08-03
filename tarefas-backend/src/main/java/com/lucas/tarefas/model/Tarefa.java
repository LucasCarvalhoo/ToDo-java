package com.lucas.tarefas.model;

import com.lucas.tarefas.enums.Status;
import com.lucas.tarefas.model.converters.StatusConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

@Entity
@Data
@Where(clause = "status = 'Ativo'")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricao;

    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;
}
