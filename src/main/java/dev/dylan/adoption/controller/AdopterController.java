package dev.dylan.adoption.controller;

import dev.dylan.adoption.Services.AdopterService;
import dev.dylan.adoption.domain.Adopter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopters")
public class AdopterController {

  private final AdopterService adopterService;

  public AdopterController(AdopterService adopterService) {
    this.adopterService = adopterService;
  }

  @GetMapping
  public ResponseEntity<?> getAllAdopters() {
    List<Adopter> adopters = adopterService.findAll();
    return ResponseEntity.ok(adopters);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAdopter(@PathVariable("id") int id) {
    Adopter a = adopterService.find(id);
    if (a == null)
      return ResponseEntity.notFound().build();
    else
      return ResponseEntity.ok(a);
  }

  @PostMapping
  public ResponseEntity<?> createAdopter(@RequestBody Adopter a) {
    a = adopterService.newAdopter(a);
    return ResponseEntity.ok(a);
  }

  @PostMapping("/{id}")
  public ResponseEntity<?> updateAdopter(@PathVariable("id") int id, @RequestBody Adopter a) {
    Integer existingId = a.getId();

    if(existingId != null && existingId != id) {
      return ResponseEntity.badRequest().body("Id in request body and id in query parameter do not match");
    } else {
      a.setId(id);
      adopterService.update(a);
      return  ResponseEntity.ok(a);
    }
  }
}
