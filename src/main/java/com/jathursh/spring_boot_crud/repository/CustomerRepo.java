package com.jathursh.spring_boot_crud.repository;

import com.jathursh.spring_boot_crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    // creating a custom method
    Customer findByName(String name);
}
