package com.lucas.tarefas.controller;

import com.lucas.tarefas.model.Tarefa;
import com.lucas.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> getTask(){
        return tarefaService.listarTarefas();
    }

    @PostMapping
    public Tarefa addTask(@RequestBody Tarefa tarefa) {
        return tarefaService.adicionarTarefas(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
