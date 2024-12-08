package com.example.soap.service;

import com.example.soap.Entities.*;
import com.example.soap.repo.ClientRepository;
import com.example.soap.repo.ChambreRepository;
import com.example.soap.repo.ReservationRepository;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@WebService(endpointInterface = "com.example.soap.service.HotelService")
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Chambre> getAvailableRooms() {
        return chambreRepository.findByDisponible(true);
    }

    @Override
    public Reservation makeReservation(Long clientId, Long chambreId, String dateDebut, String dateFin, String preferences) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé"));
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new IllegalArgumentException("Chambre non disponible"));

        LocalDate debut = LocalDate.parse(dateDebut);
        LocalDate fin = LocalDate.parse(dateFin);
        if (debut.isAfter(fin)) {
            throw new IllegalArgumentException("La date de début doit être avant la date de fin");
        }

        chambre.setDisponible(false);
        chambreRepository.save(chambre);

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(debut);
        reservation.setDateFin(fin);
        reservation.setPreferences(preferences);

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElse(null);
    }

    @Override
    public Reservation updateReservation(Long reservationId, String newDateDebut, String newDateFin, String newPreferences) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Réservation non trouvée"));

        if (newDateDebut != null) {
            reservation.setDateDebut(LocalDate.parse(newDateDebut));
        }
        if (newDateFin != null) {
            reservation.setDateFin(LocalDate.parse(newDateFin));
        }
        if (newPreferences != null) {
            reservation.setPreferences(newPreferences);
        }

        return reservationRepository.save(reservation);
    }

    @Override
    public boolean deleteReservation(Long reservationId) {
        if (reservationRepository.existsById(reservationId)) {
            reservationRepository.deleteById(reservationId);
            return true;
        }
        return false;
    }
}