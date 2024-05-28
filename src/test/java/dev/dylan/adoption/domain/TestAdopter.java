package dev.dylan.adoption.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAdopter {
    Animal validAnimal = new Animal("Theo", AnimalType.CAT, "Siamese");

    @Test
    public void TestNameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var adopter = new Adopter("", 234567890, validAnimal);
        });
        assertTrue(exception.getMessage().contains("Name cannot be blank"));
    }

    @Test
    public void TestPhoneValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var adopter = new Adopter("Felix", 123, validAnimal);
        });
        assertTrue(exception.getMessage().contains("Phone number must be 7 digits"));
    }

}
