package com.praticien.controller;

import com.praticien.model.Praticien;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/praticiens")
public class PraticienController {
    private List<Praticien> praticiens = new ArrayList<>(Arrays.asList(
            new Praticien(1L, "Timothy", "Riquiet", "Cardiologie")
    ));


    /**
     * Récupère la liste de tous les praticiens.
     */
    @GetMapping
    public List<Praticien> getAllPraticiens() {
        return praticiens;
    }

    /**
     * Ajoute un nouveau praticien.
     */
    @PostMapping
    public Praticien addPraticien(@RequestBody Praticien praticien) {
        praticiens.add(praticien);
        return praticien;
    }

    /**
     * Met à jour un praticien existant.
     */
    @PutMapping("/{id}")
    public Praticien updatePraticien(@PathVariable Long id, @RequestBody Praticien updatedPraticien) {
        Optional<Praticien> existing = praticiens.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(existing.isPresent()){
            Praticien praticien = existing.get();
            praticien.setFirstName(updatedPraticien.getFirstName());
            praticien.setLastName(updatedPraticien.getLastName());
            praticien.setSpecialty(updatedPraticien.getSpecialty());
            return praticien;
        }
        return null;
    }

    /**
     * Supprime un praticien.
     */
    @DeleteMapping("/{id}")
    public String deletePraticien(@PathVariable Long id) {
        boolean removed = praticiens.removeIf(p -> p.getId().equals(id));
        if (removed) {
            return "Praticien avec l'id " + id + " supprimé avec succès.";
        } else {
            return "Praticien avec l'id " + id + " non trouvé.";
        }
    }
}
