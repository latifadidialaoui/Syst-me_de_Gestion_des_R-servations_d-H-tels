package com.example.rest.controllers;
import com.example.rest.entities.Chambre;
import com.example.rest.services.ChambreService;
import com.example.rest.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;


    @PostMapping
    public ResponseEntity<Chambre> createChambre(@RequestBody Chambre chambre) {
        Chambre createdChambre = chambreService.createChambre(chambre);
        return ResponseEntity.ok(createdChambre);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreService.getChambreById(id);
        return chambre.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Chambre non trouvée avec l'id : " + id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre chambreDetails) {
        Chambre updatedChambre = chambreService.updateChambre(id, chambreDetails);
        return ResponseEntity.ok(updatedChambre);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
        return ResponseEntity.noContent().build();
    }
}

