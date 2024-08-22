package com.lucas.tarefas.service;

import com.lucas.tarefas.model.Tarefa;
import com.lucas.tarefas.repository.TarefaRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa adicionarTarefas(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public Tarefa findById(@NotNull @Positive Long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        return tarefaOptional.orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }
}
