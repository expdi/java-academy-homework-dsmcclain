package dev.dylan.adoption.Services;

import dev.dylan.adoption.domain.Animal;
import dev.dylan.adoption.domain.AnimalType;
import dev.dylan.adoption.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
  public AnimalRepository repository;

  @Autowired
  public AnimalService(AnimalRepository repository) {
    this.repository = repository;
  }

  public Animal newAnimal(String name, AnimalType type, String breed) {
    Animal animal = new Animal(name, type, breed);
    animal = repository.save(animal);

    return animal;
  }

  public Animal newAnimal(Animal animal) {
    return repository.save(animal);
  }

  public boolean update(Animal animal) {
    Animal oldAnimal = repository.findById(animal.getId()).orElse(null);
    if(oldAnimal != null) {
      repository.save(animal);
      return true;
    } else {
      return false;
    }

  }
}
