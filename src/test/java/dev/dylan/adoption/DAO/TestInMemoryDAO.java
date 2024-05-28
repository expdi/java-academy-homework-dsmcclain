//package dev.dylan.adoption.DAO;
//
//
//import dev.dylan.adoption.models.Adopter;
//import dev.dylan.adoption.models.Animal;
//import dev.dylan.adoption.models.AnimalType;
//import dev.dylan.adoption.models.Entity;
//
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.Map;
//
//import static java.util.Map.entry;
//import static org.junit.Assert.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class TestInMemoryDAO {
//    private Animal mockAnimal = new Animal(1, "Test Cat",AnimalType.CAT, "tabby");
//    private Adopter mockAdopter = new Adopter(1, "Test Adopter", 1234567, LocalDate.now(), mockAnimal);
//    private Map<Integer, Entity> adopterDatabase = new HashMap<Integer, Entity>(Map.ofEntries(entry(mockAdopter.getId(), mockAdopter)));
//    public InMemoryDAO inMemoryDAO = new InMemoryDAO(adopterDatabase);
//
//    @Test
//    public void TestGetByName() {
//        assertEquals(inMemoryDAO.getByName("Test Adopter"), mockAdopter);
//    }
//
//}
