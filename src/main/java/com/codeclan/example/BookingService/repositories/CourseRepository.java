package com.codeclan.example.BookingService.repositories;

import com.codeclan.example.BookingService.models.Course;
import com.codeclan.example.BookingService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository <Course, Long> {

    List<Course> findByRating(int Rating);
    List<Course> findByBookingsCustomerName(String name);
}
