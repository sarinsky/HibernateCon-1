package com.trnetwork.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trnetwork.model.Docente;
import com.trnetwork.repository.DocenteRepository;

@Configuration
public class DocenteConfig {
	
	CommandLineRunner commandLineRunner(
			DocenteRepository repository) {
		return args->{
			Docente docente1=new Docente(
					"JOSE ALFREDO",
					"josealfredo@gmail.com",
					LocalDate.of(1995, Month.APRIL, 5)
					);
			Docente docente2=new Docente(
					"CARIBE LOPEZ",
					"caribe@gmail.com",
					LocalDate.of(1990, Month.AUGUST, 10)
					);
				repository.saveAll(List.of(docente1, docente2));
		};
	}
}
