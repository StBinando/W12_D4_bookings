package com.codeclan.example.BookingService.controllers;

import com.codeclan.example.BookingService.models.Booking;
import com.codeclan.example.BookingService.models.Customer;
import com.codeclan.example.BookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/getByTown")
    public ResponseEntity<List<Customer>> getCustomerByTown(@RequestParam String town){
        return new ResponseEntity<>(customerRepository.findByTown(town), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/getByCourse")
    public ResponseEntity<List<Customer>> getCustomerByCourse(@RequestParam String name) {
        return new ResponseEntity<>(customerRepository.findByBookingCourseName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/getbytownandcourse")
    public ResponseEntity<List<Customer>> getCustomerByTownAndCourse(@RequestParam (name = "town") String town, @RequestParam (name = "name") String name) {
        return new ResponseEntity<>(customerRepository.findByTownAndBookingCourseName(town, name), HttpStatus.OK);
    }



    @GetMapping(value = "/customers/getbyageandtownandcourse")
    public ResponseEntity<List<Customer>> getCustomerByAgeGreaterThanAndTownAndCourse(@RequestParam (name = "age") int age, @RequestParam (name = "town") String town, @RequestParam (name = "coursename") String coursename){
        return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingCourseName(age, town, coursename), HttpStatus.OK);
    }


    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerNew) {
        customerNew.setId(id);
        customerRepository.save(customerNew);
        return new ResponseEntity<>(customerNew, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
