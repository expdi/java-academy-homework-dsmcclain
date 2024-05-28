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

    private final AnimalService animalService;
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
      adopter.addAnimal(animal);

      return adopter;
    }

    public boolean update(Adopter adopter) {
      Adopter oldAdopter = repository.findById(adopter.getId()).orElse(null);
      if(oldAdopter != null) {
        repository.save(adopter);
        return true;
      } else {
        return false;
      }
    }

    public boolean delete(int id) {
      Adopter adopter = repository.findById(id).orElse(null);
      if(adopter != null)
        return delete(adopter);
      else
        return false;
    }

    public boolean delete(Adopter adopter) {
      repository.delete(adopter);
      return true;
    }

    public List<Adopter> findAll() {
      return repository.findAdoptersWithAdoptions();
    }

    public Adopter find(int id) {
      return repository.findAdopterWithAdoptions(id).orElse(null);
    }
}
