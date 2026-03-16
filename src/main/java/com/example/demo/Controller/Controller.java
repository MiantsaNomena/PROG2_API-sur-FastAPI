package com.example.demo.Controller;

import com.example.demo.Entity.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private List<Reservation> reservations = new ArrayList<>();

    @GetMapping("/booking")
    List<Reservation> getHotelReservations() {
        return reservations;
    }

    @PostMapping("/Booking")
    public ResponseEntity<?> addBooking(@RequestBody Reservation reservation) {

        if (reservation.getRoomNumber() < 1 || reservation.getRoomNumber() > 9) {
            return ResponseEntity.badRequest()
                    .body("Room numbers must be between 1 and 9");
        }

        for (Reservation b : reservations) {
            if (b.getRoomNumber() == reservation.getRoomNumber()
                    && b.getReservationDate().equals(reservation.getReservationDate())) {

                return ResponseEntity.status(409)
                        .body("Room already booked for this date");
            }
        }

        reservations.addAll(reservations);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservations);
    }


}
