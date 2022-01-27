package com.codeclan.example.BookingService.components;

import com.codeclan.example.BookingService.models.Booking;
import com.codeclan.example.BookingService.models.Course;
import com.codeclan.example.BookingService.models.Customer;
import com.codeclan.example.BookingService.repositories.BookingRepository;
import com.codeclan.example.BookingService.repositories.CourseRepository;
import com.codeclan.example.BookingService.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) {

       Customer customer1 = new Customer("Mary", 35, "Edinburgh");
       customerRepository.save(customer1);
       Customer customer2 = new Customer("Jane", 23, "Glasgow");
       customerRepository.save(customer2);
       Customer customer3 = new Customer("James", 47, "Aberdeen");
       customerRepository.save(customer3);

       Course course1 = new Course("yoga", "Dundee", 4);
       courseRepository.save(course1);
       Course course2 = new Course("swimming", "Inverness", 5);
       courseRepository.save(course2);
       Course course3 = new Course("photography", "Glasgow", 3);
       courseRepository.save(course3);

       Booking booking1 = new Booking("11-05-2022", customer1, course1);
       bookingRepository.save(booking1);
       Booking booking2 = new Booking("15-12-2021", customer2, course1);
       bookingRepository.save(booking2);
       Booking booking3 = new Booking("10-02-2022", customer3, course2);
       bookingRepository.save(booking3);
       Booking booking4 = new Booking("03-07-2022", customer1, course2);
       bookingRepository.save(booking4);
       Booking booking5 = new Booking("25-11-2021", customer2, course3);
       bookingRepository.save(booking5);
       Booking booking6 = new Booking("30-10-2021", customer3, course3);
       bookingRepository.save(booking6);
    }
}
