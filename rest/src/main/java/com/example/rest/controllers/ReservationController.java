package com.example.rest.controllers;

import com.example.rest.entities.Reservation;
import com.example.rest.services.ReservationService;
import com.example.rest.services.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Réservation non trouvée"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Long id,
            @RequestBody Reservation newReservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, newReservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}


