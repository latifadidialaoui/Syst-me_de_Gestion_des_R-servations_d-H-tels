package com.example.soap.repo;

import com.example.soap.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClient_IdClient(Long clientId); // Utilisez le nom de la propriété ici
}