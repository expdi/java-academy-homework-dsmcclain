package dev.dylan.adoption;

import dev.dylan.adoption.Services.AdopterService;
import dev.dylan.adoption.Services.AnimalService;
import dev.dylan.adoption.domain.Adopter;
import dev.dylan.adoption.domain.Animal;
import dev.dylan.adoption.domain.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdoptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdoptionApplication.class, args);
	}
//
//  @Autowired
//	AdopterService adopterService;
//
//	@Autowired
//	AnimalService animalService;
//	@Bean
//	public CommandLineRunner runner() {
//		Animal animal = animalService.newAnimal("George", AnimalType.CAT, "Longhair");
//		Animal animal2 = animalService.newAnimal("Alfredo", AnimalType.DOG, "Dalmation");
//		Adopter adopter = adopterService.newAdopter("Becky", 7777777, animal);
////		List<Adopter> adopters = adopterService.findAll();
////
////		adopters.forEach(System.out::println);
//
//		System.out.println(adopterService.find(adopter.getId()));
//
//
//		return args -> {};
//	}
}

