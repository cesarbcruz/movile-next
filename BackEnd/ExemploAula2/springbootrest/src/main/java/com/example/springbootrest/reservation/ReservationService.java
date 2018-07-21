package com.example.springbootrest.reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Retrieve all rows from table and populate list with objects
    public List getAllReservations() {

        List reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);

        return reservations;
    }

    // Retrieves one row from table based on given id
    public Reservation getReservation(String id) {
        return reservationRepository.findById(id).get();

    }

    // Inserts row into table
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    // Updates row in table
    public void updateReservation(String id, Reservation reservation) {
        reservationRepository.save(reservation);
    }

    // Removes row from table
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
