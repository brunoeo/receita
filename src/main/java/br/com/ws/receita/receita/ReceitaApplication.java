package br.com.ws.receita.receita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.ws.receita.receita.model")
@SpringBootApplication
public class ReceitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitaApplication.class, args);
	}

}
