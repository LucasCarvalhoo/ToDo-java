package com.lucas.tarefas;

import com.lucas.tarefas.enums.Status;
import com.lucas.tarefas.model.Tarefa;
import com.lucas.tarefas.repository.TarefaRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.lucas")
@EnableJpaRepositories(basePackages = "com.lucas.tarefas.repository")
@EntityScan(basePackages = "com.lucas.tarefas.model")
@OpenAPIDefinition(info = @Info(title = "Tarefas API", version = "1", description = "API desenvolvida para gerenciar tarefas"))
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);

	}
	@Bean
	CommandLineRunner initDatabase(TarefaRepository tarefaRepository){
		return args -> {
			tarefaRepository.deleteAll();

			Tarefa p = new Tarefa();
			p.setDescricao("Estudar spring-boot");

			tarefaRepository.save(p);
		};
	}
}
