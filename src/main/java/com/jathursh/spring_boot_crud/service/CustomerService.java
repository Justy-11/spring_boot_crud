package com.jathursh.spring_boot_crud.service;

import com.jathursh.spring_boot_crud.dto.CustomerDto;
import com.jathursh.spring_boot_crud.entity.Customer;
import com.jathursh.spring_boot_crud.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// this CustomerService will talk to customerRepo
public class CustomerService {

    /*
    @Autowired is a Spring framework annotation used to automatically wire beans in your application. When you mark a field, constructor, or method with @Autowired, Spring will automatically inject an instance of the required bean at runtime.
For example, suppose you have a service class called UserService that requires an instance of a UserRepository to work with data in a database. Instead of instantiating a UserRepository object manually, you can use @Autowired to instruct Spring to inject an instance of the UserRepository at runtime.
     */
    @Autowired
    private CustomerRepo customerRepo;

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public CustomerDto saveCustomerDto(CustomerDto customerDto){
        Customer customerSaved=  new Customer();
        customerSaved.setId(customerDto.getId());
        customerSaved.setEmail(customerDto.getEmail());
        customerSaved.setAddress(customerDto.getAddress());
        customerSaved.setName(customerDto.getName());

        Customer savedCustomer = customerRepo.save(customerSaved);
        return new CustomerDto(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail(), savedCustomer.getAddress());

    }

    public List<Customer> saveCustomers(List<Customer> customers){
        return customerRepo.saveAll(customers);
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id){
        return customerRepo.findById(id).orElse(null);
    }

    public Customer getCustomerByName(String name){
        return customerRepo.findByName(name);
    }

    public String deleteCustomer(int id){
        customerRepo.deleteById(id);
        return "Customer removed " + id;
    }

    public Customer updateCustomer(Customer customer){
        Customer existingCustomer = customerRepo.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepo.save(existingCustomer);

    }

}
