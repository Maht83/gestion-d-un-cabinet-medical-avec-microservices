package com.patient.controller;

import com.patient.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private List<Patient> patients = new ArrayList<>(Arrays.asList(
            new Patient(1L, "Julien", "Varupenne", 45)
    ));


    /**
     * Récupère la liste de tous les patients.
     * @return la liste des patients
     */
    @GetMapping
    public List<Patient> getAllPatients() {
        return patients;
    }

    /**
     * Ajoute un nouveau patient.
     * @param patient le patient à ajouter (passé dans le corps de la requête)
     * @return le patient ajouté
     */
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        patients.add(patient);
        return patient;
    }

    /**
     * Met à jour un patient existant.
     * @param id l'identifiant du patient à mettre à jour
     * @param updatedPatient les nouvelles informations du patient
     * @return le patient mis à jour, ou un message d'erreur si non trouvé
     */
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Optional<Patient> optionalPatient = patients.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setFirstName(updatedPatient.getFirstName());
            patient.setLastName(updatedPatient.getLastName());
            patient.setAge(updatedPatient.getAge());
            return patient;
        }

        return null;
    }

    /**
     * Supprime un patient.
     * @param id l'identifiant du patient à supprimer
     * @return un message de confirmation
     */
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        boolean removed = patients.removeIf(patient -> patient.getId().equals(id));
        if (removed) {
            return "Patient avec l'id " + id + " supprimé avec succès.";
        } else {
            return "Patient avec l'id " + id + " non trouvé.";
        }
    }
}
