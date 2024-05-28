package dev.dylan.adoption.repository;

import dev.dylan.adoption.domain.Adopter;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class AdopterRepositoryTest {
  @Autowired
  private AdopterRepository adopterRepository;

  @Test
  public void testGetAdopterWithAdoptions() {
    Adopter newAdopter = new Adopter("test", 1234567);
    newAdopter = adopterRepository.save(newAdopter);

    Adopter fetchedAdopter = adopterRepository.findAdopterWithAdoptions(newAdopter.getId()).get();
    System.out.println(fetchedAdopter);
//    adopterRepository.findAll().forEach(System.out::println);
  }
}
