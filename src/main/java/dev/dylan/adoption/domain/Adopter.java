package dev.dylan.adoption.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Adopter {
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private int phoneNumber;

  @OneToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "adopter",
    fetch = FetchType.LAZY
  )
  @JsonIgnore
  private Set<Animal> animals;

  public Adopter() {}

  public Adopter(String name, int phoneNumber) {
    this(name, phoneNumber, List.of());
  }

  public Adopter(String name, int phoneNumber, Animal animal) {
    this(name, phoneNumber, List.of(animal));
  }

  private Adopter(String name, int phoneNumber, List<Animal> animals) {
    Validate.notBlank(name, "Name cannot be blank");
    Validate.inclusiveBetween(1000000,9999999, phoneNumber, "Phone number must be 7 digits");
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.animals = new HashSet<>(animals);
  }

  @Override
  public String toString() {
    return STR."Adopter{id=\{id}, name='\{name}\{'\''}, phoneNumber=\{phoneNumber}, adoptions=\{animals}\{'}'}";
  }
}
