package com.lucas.tarefas.controller;

import com.lucas.tarefas.model.Tarefa;
import com.lucas.tarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "retorna todas as tarefas",
            description = "Esse método recupera uma lista de tarefa.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a busca de dados"),
    })
    @GetMapping
    public List<Tarefa> getTask(){
        return tarefaService.listarTarefas();
    }

    @Operation(summary = "cria uma nova tarefas",
            description = "Esse método cria nova tarefa.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar tarefa"),
    })
    @PostMapping
    public Tarefa addTask(@RequestBody Tarefa tarefa) {
        return tarefaService.adicionarTarefas(tarefa);
    }

    @Operation(summary = "apaga uma tarefa",
            description = "Esse método remove uma tarefa utilizando o `id` como parâmetro.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "tarefa removida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar tarefa"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "busca uma tarefa pelo id",
            description = "Esse método busca uma tarefa pelo id.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a busca de dados"),
    })
    @GetMapping("/{id}")
    public Tarefa findById(@PathVariable Long id) {
        return tarefaService.findById(id);
    }
}
