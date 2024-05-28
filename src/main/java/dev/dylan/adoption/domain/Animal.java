package dev.dylan.adoption.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;

@Getter
@Setter
@Entity
public class Animal {
    @Id
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalType type;
    private String breed;

    @ManyToOne
    private Adopter adopter;
    public Animal( String name, AnimalType type) {
        init(name, type, null);
    }

    public Animal(String name, AnimalType type, String breed) {
        init(name, type, breed);
    }

//    public Animal( String name, AnimalType type, String breed, int adopter_id) { init(name, type, breed ); }

    public Animal() {

    }

    public void init(String name, AnimalType type, String breed) {
        Validate.notBlank(name, "Name cannot be blank");
        this.name = name;
        this.type = type;
        this.breed = breed;
    }
    @Override
    public String toString() {
        return STR."Animal{id=\{id}, name='\{name}\{'\''}, type=\{type}, breed='\{breed}\{'\''}\{'}'}";
    }
}
