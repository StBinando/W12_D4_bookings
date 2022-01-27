package com.codeclan.example.BookingService.controllers;

import com.codeclan.example.BookingService.models.Booking;
import com.codeclan.example.BookingService.models.Course;
import com.codeclan.example.BookingService.models.Customer;
import com.codeclan.example.BookingService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourse() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/course/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(Long id) {
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbyrating")
    public ResponseEntity<List<Course>> getCourseByRating(@RequestParam int rating) {
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbycustomername")
    public ResponseEntity<List<Course>> getCoursesByCustomerName(@RequestParam String name) {
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(name), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseNew) {
        courseNew.setId(id);
        courseRepository.save(courseNew);
        return new ResponseEntity<>(courseNew, HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<List<Course>> deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
