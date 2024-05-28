package dev.dylan.adoption.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class TestAnimal {
    @Test
    public void TestNameValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var animal = new Animal("", AnimalType.CAT);
        });
        assertTrue(exception.getMessage().contains("Name cannot be blank"));
    }

    @Test
    public void TestNullBreed() {
        var animal = new Animal("Joey", AnimalType.DOG);
        assertThat(animal, instanceOf(Animal.class));
    }

    @Test
    public void TestAcceptsBreed() {
        var animal = new Animal("Joey", AnimalType.DOG, "Dachshund");
        assertThat(animal, instanceOf(Animal.class));
    }
}
