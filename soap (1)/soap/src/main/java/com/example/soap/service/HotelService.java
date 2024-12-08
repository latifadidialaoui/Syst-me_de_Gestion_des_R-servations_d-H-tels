package com.example.soap.service;

import com.example.soap.Entities.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface HotelService {

    @WebMethod
    List<Client> getAllClients();

    @WebMethod
    Client addClient(@WebParam(name = "client") Client client);

    @WebMethod
    List<Chambre> getAvailableRooms();

    @WebMethod
    Reservation makeReservation(
            @WebParam(name = "clientId") Long clientId,
            @WebParam(name = "chambreId") Long chambreId,
            @WebParam(name = "dateDebut") String dateDebut,
            @WebParam(name = "dateFin") String dateFin,
            @WebParam(name = "preferences") String preferences
    );

    @WebMethod
    Reservation getReservation(@WebParam(name = "reservationId") Long reservationId);

    @WebMethod
    Reservation updateReservation(
            @WebParam(name = "reservationId") Long reservationId,
            @WebParam(name = "newDateDebut") String newDateDebut,
            @WebParam(name = "newDateFin") String newDateFin,
            @WebParam(name = "newPreferences") String newPreferences
    );

    @WebMethod
    boolean deleteReservation(@WebParam(name = "reservationId") Long reservationId);
}