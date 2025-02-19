package com.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gateway")
public class GatewayController {
    @Autowired
    private RestTemplate restTemplate;

    // Endpoint pour obtenir les détails d'un patient
    @HystrixCommand(fallbackMethod = "fallbackPatient")
    @GetMapping("/patient/{id}")
    public String getPatientDetails(@PathVariable Long id) {
        // Appel vers le service patient via Eureka (lb:// utilise le load balancing)
        String response = restTemplate.getForObject("http://patient-service/patients/" + id, String.class);
        return "Patient Details for id " + id + ": " + response;
    }

    // Méthode de fallback en cas d'échec de l'appel au service patient
    public String fallbackPatient(Long id) {
        return "Patient Service is down. Please try again later for patient id: " + id;
    }

    // Endpoint pour obtenir les détails d'un praticien
    @HystrixCommand(fallbackMethod = "fallbackPraticien")
    @GetMapping("/praticien/{id}")
    public String getPraticienDetails(@PathVariable Long id) {
        // Appel vers le service praticien via Eureka
        String response = restTemplate.getForObject("http://praticien-service/praticiens/" + id, String.class);
        return "Praticien Details for id " + id + ": " + response;
    }

    // Méthode de fallback en cas d'échec de l'appel au service praticien
    public String fallbackPraticien(Long id) {
        return "Praticien Service is down. Please try again later for praticien id: " + id;
    }

    // Définition d'un RestTemplate load-balanced pour exploiter Eureka
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
