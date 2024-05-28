//package dev.dylan.adoption.models;
//
//
//import org.junit.Test;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestAdopter {
//    Animal validAnimal = new Animal(1, "Theo", AnimalType.CAT, "Siamese");
//    Animal nullAnimal = null;
//
//    @Test
//    public void TestAdopterCreation() {
//        LocalDate time = LocalDate.now();
//        var adopter = new Adopter(1, "Test", 1234567, time, validAnimal);
//        assertEquals(adopter.getClass(), Adopter.class);
//        assertEquals(adopter.getId(), 1);
//        assertEquals(adopter.getName(), "Test");
//        assertEquals(adopter.getPhoneNumber(), 1234567);
//        assertEquals(adopter.getAdoptionDate(), time);
//        assertEquals(adopter.getPetType(), validAnimal.getType());
//        assertEquals(adopter.getPetName(),validAnimal.getName());
//        assertEquals(adopter.getPetBreed(), validAnimal.getBreed());
//    }
//
//    @Test
//    public void TestAdopterToString() {
//        LocalDate time = LocalDate.now();
//        var adopter = new Adopter(1, "Test", 1234567, time, validAnimal);
//        String adopterString = STR."""
//                Adopter{id=\{adopter.getId()}, name='\{adopter.getName()}', phoneNumber=\{adopter.getPhoneNumber()}, \
//                adoptionDate=\{adopter.getAdoptionDate()}, petType=\{adopter.getPetType()}, \
//                petName='\{adopter.getPetName()}', petBreed='\{adopter.getPetBreed()}'}
//               """;
//
//        assertEquals(adopter.toString(), adopterString);
//    }
//
//    @Test
//    public void TestNameValidation() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            var adopter = new Adopter(1, "", 234567890, LocalDate.now(), validAnimal);
//        });
//        assertTrue(exception.getMessage().contains("Name cannot be blank"));
//    }
//
//    @Test
//    public void TestAnimalValidation() {
//        Exception exception = assertThrows(NullPointerException.class, () -> {
//            var adopter = new Adopter(1, "Felix", 234567890, LocalDate.now(), nullAnimal);
//        });
//        assertTrue(exception.getMessage().contains("Animal cannot be null"));
//    }
//
//    @Test
//    public void TestPhoneValidation() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            var adopter = new Adopter(1, "Felix", 123, LocalDate.now(), validAnimal);
//        });
//        assertTrue(exception.getMessage().contains("Phone number must be 7 digits"));
//    }
//
//    @Test
//    public void TestId() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            var adopter = new Adopter(-1, "Felix", 1234567, LocalDate.now(), validAnimal);
//        });
//        assertTrue(exception.getMessage().contains("ID must be a positive integer"));
//    }
//}
