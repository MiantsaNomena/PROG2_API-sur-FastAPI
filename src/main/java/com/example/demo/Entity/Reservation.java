package com.example.demo.Entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Reservation {
    private String customerName;
    private String customerPhoneNumber;
    private String customerEmail;
    private int roomNumber;
    private String roomDescription;
    private LocalDate reservationDate;
}
