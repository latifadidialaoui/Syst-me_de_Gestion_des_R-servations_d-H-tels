package com.example.rest.services;

import com.example.rest.entities.Reservation;
import com.example.rest.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation updateReservation(Long id, Reservation newReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setDateDebut(newReservation.getDateDebut());
                    reservation.setDateFin(newReservation.getDateFin());
                    reservation.setPreferences(newReservation.getPreferences());
                    return reservationRepository.save(reservation);
                }).orElseThrow(() -> new ResourceNotFoundException("Réservation non trouvée"));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
