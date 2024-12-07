package com.example.rest.services;



import com.example.rest.entities.Chambre;
import com.example.rest.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;

    public Chambre createChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre updateChambre(Long id, Chambre chambreDetails) {
        return chambreRepository.findById(id)
                .map(chambre -> {
                    chambre.setType(chambreDetails.getType());
                    chambre.setPrix(chambreDetails.getPrix());
                    chambre.setDisponible(chambreDetails.getDisponible());
                    return chambreRepository.save(chambre);
                }).orElseThrow(() -> new ResourceNotFoundException("Chambre non trouvée"));
    }

    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}

