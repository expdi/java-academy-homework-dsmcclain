package dev.dylan.adoption.repository;

import dev.dylan.adoption.domain.Adopter;
import dev.dylan.adoption.domain.Animal;
import dev.dylan.adoption.domain.AnimalType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AdopterRepositoryTest {
  @Autowired
  private AdopterRepository adopterRepository;

  @Autowired
  private AnimalRepository animalRepository;

  @BeforeEach
  public void setup() {
    Animal newAnimal = new Animal("test animal", AnimalType.CAT, "tabby");
    Adopter newAdopter = new Adopter("test", 1234567, newAnimal);
    adopterRepository.save(newAdopter);
  }

  @Test
  public void testGetAdopterWithAdoptions() {
    Adopter fetchedAdopter = adopterRepository.findAdopterWithAdoptions(1).get();
    assertEquals(1, fetchedAdopter.getId());
    assertEquals( "test", fetchedAdopter.getName());
    assertEquals(Set.of(animalRepository.findById(1).get()), fetchedAdopter.getAnimals());
  }

  @Test
  public void testGetAdoptersWithAdoptions() {
    Animal newAnimal2 = new Animal("test animal", AnimalType.CAT, "tabby");
    Adopter newAdopter2 = new Adopter("test", 1234567, newAnimal2);
    adopterRepository.save(newAdopter2);

    List<Adopter> fetchedAdopters = adopterRepository.findAdoptersWithAdoptions();

    assertEquals(fetchedAdopters.size(), 2);
    fetchedAdopters.forEach(a -> {
      assertEquals(a.getAnimals().size(), 1);
    });
  }
}
