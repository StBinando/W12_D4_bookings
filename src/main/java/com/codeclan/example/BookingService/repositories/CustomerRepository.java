package com.codeclan.example.BookingService.repositories;

import com.codeclan.example.BookingService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByTown(String town);
    List<Customer> findByBookingCourseName(String name);
    List<Customer> findByTownAndBookingCourseName (String town, String name);
    List<Customer> findByAgeGreaterThanAndTownAndBookingCourseName (int age,
                                                                     String town,
                                                                     String coursename);
}


