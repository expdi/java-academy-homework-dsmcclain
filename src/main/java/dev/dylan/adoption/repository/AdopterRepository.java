package dev.dylan.adoption.repository;

import dev.dylan.adoption.domain.Adopter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Integer> {

  @Query("select a from Adopter a left join fetch a.animals")
  List<Adopter> findAdoptersWithAdoptions();

  @Query("select a from Adopter a left join fetch a.animals where a.id = :id")
  Optional<Adopter> findAdopterWithAdoptions(int id);
}
