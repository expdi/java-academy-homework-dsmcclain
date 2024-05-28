package dev.dylan.adoption.Services;

import dev.dylan.adoption.domain.Adopter;
import dev.dylan.adoption.domain.Animal;
import dev.dylan.adoption.repository.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdopterService {
    public AdopterRepository repository;

    private AnimalService animalService;
    @Autowired
    public AdopterService(AdopterRepository repository, AnimalService animalService) {
      this.repository = repository;
      this.animalService = animalService;
    }

    public Adopter newAdopter(String name, int phoneNumber) {
      Adopter adopter = new Adopter(name, phoneNumber);
      adopter = repository.save(adopter);

      return adopter;
    }

    public Adopter newAdopter(Adopter adopter) {
      adopter = repository.save(adopter);
      return adopter;
    }

    public Adopter newAdopter(Adopter adopter, Animal animal) {
      if (animal.getId() == null)
        animalService.newAnimal(animal);

      adopter = repository.save(adopter);

      return adopt(adopter, animal);
    }

    public Adopter adopt(Adopter adopter, Animal animal) {
      animal.setAdopter(adopter);
      if(animalService.update(animal)) {
        Set<Animal> animals = adopter.getAnimals();
        animals.add(animal);
        adopter.setAnimals(animals);
        adopter = repository.save(adopter);
        return adopter;
      } else {
        throw new RuntimeException("failed to update animal");
      }
    }

    public List<Adopter> findAll() {
      return repository.findAdoptersWithAdoptions();
    }

    public Adopter find(int id) {
      return repository.findAdopterWithAdoptions(id).orElse(null);
    }
}