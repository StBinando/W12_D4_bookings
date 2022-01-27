package com.codeclan.example.BookingService.controllers;

import com.codeclan.example.BookingService.models.Booking;
import com.codeclan.example.BookingService.models.Course;
import com.codeclan.example.BookingService.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable Long id){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/getByDate")
    public ResponseEntity<List<Booking>> getBookingByDate(@RequestParam(name = "date") String date){
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> updateCourse(@PathVariable Long id, @RequestBody Booking bookingNew){
        bookingNew.setId(id);
        bookingRepository.save(bookingNew);
        return new ResponseEntity<>(bookingNew, HttpStatus.OK);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<List<Booking>> deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }


}
