package com.lucas.tarefas.service;

import com.lucas.tarefas.model.Tarefa;
import com.lucas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
}
