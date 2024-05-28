package dev.dylan.adoption.service;

import dev.dylan.adoption.Services.AdopterService;
import dev.dylan.adoption.domain.Adopter;
import dev.dylan.adoption.domain.Animal;
import dev.dylan.adoption.domain.AnimalType;
import dev.dylan.adoption.repository.AdopterRepository;
import dev.dylan.adoption.repository.AnimalRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class AdopterServiceTest {
  @Autowired
  private AdopterRepository adopterRepository;

  @Autowired
  private AnimalRepository animalRepository;

  @Autowired
  private AdopterService service;

  @Test
  public void testAdopt() {
    Adopter newAdopter = new Adopter("test", 1234567);
    Animal newAnimal = new Animal("test animal", AnimalType.DOG, "Poodle");
    adopterRepository.save(newAdopter);
    animalRepository.save(newAnimal);

    service.adopt(newAdopter, newAnimal);
    assertEquals(newAdopter.getAnimals(), Set.of(newAnimal));
    assertEquals(newAnimal.getAdopter(), newAdopter);
  }
}
