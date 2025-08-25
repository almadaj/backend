package br.edu.unichristus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "API da disciplina Tópicos em Web 2025.1",
				version = "1.0",
				description = "API da disciplina Tópicos em Web 2025.1",
				contact = @Contact(
						name = "Juliano Almada",
						email = "julianoalmada48@gmail.com",
						url = "https://www.github.com/almadaj/backend")


		)
)
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
