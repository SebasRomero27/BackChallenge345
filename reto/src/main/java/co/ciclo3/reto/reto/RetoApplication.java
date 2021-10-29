package co.ciclo3.reto.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.ciclo3.reto.reto.model"})
@SpringBootApplication 
public class RetoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
	}   
}