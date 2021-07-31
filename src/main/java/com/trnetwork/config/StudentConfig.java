package com.trnetwork.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.trnetwork.model.Student;
import com.trnetwork.repository.StudentRepository;

@Configuration
public class StudentConfig {
	/*We are goint to configure the bean */
	/*We are goint to have access to the repository*/
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args->{
			/*was converted in a json*/
			Student mariam= new Student(

						"mariam",
						"mariam@gmail.com",
						LocalDate.of(2000, Month.AUGUST,5)
					
						);
			Student alex=  new Student(
					
						"alex",
						"alex@gmail.com",
						LocalDate.of(2004, Month.NOVEMBER,5)

						/*was converted in a json*/);
			repository.saveAll(
					List.of(mariam, alex ));
		};
	}
}
