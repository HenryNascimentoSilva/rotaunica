package com.viagens.rotaunica.controllers;

import com.viagens.rotaunica.entities.Excursion;
import com.viagens.rotaunica.handlers.ExcursionNotFoundException;
import com.viagens.rotaunica.repositories.ExcursionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class ExcursionController {

    private final ExcursionRepository repository;

    @GetMapping("/excursions")
    List<Excursion> all() {
        return repository.findAll();
    }

    @PostMapping("/excursions")
    Excursion newExcursion(@RequestBody Excursion excursion) {
        return repository.save(excursion);
    }

    @GetMapping("/excursion/{uuid}")
    Excursion excursion(@PathVariable UUID uuid) {
        return repository.findById(uuid)
                .orElseThrow(() -> new ExcursionNotFoundException(uuid));
    }

    @PutMapping("/excursions/{uuid}")
    Excursion updateExcursion(@RequestBody Excursion newExcursion, @PathVariable UUID uuid) {
        return repository.findById(uuid)
                .map(excursion -> {
                    excursion.setTitle(newExcursion.getTitle());
                    excursion.setPrice(newExcursion.getPrice());
                    excursion.setDescription(newExcursion.getDescription());
                    excursion.setBuyLink(newExcursion.getBuyLink());
                    excursion.setDescriptionURL(newExcursion.getDescriptionURL());
                    return repository.save(excursion);
                })
                .orElseGet(() -> repository.save(newExcursion));
    }

    @DeleteMapping("/excursions/{uuid}")
    void deleteExcursion(@PathVariable UUID uuid) {
        repository.deleteById(uuid);
    }
}
