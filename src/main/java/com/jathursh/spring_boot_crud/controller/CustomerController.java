package com.jathursh.spring_boot_crud.controller;

import com.jathursh.spring_boot_crud.dto.CustomerDto;
import com.jathursh.spring_boot_crud.entity.Customer;
import com.jathursh.spring_boot_crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController is a Spring framework annotation used to indicate that a Java class is a RESTful web service. When you mark a
 class with @RestController, Spring will automatically create a Spring bean to handle incoming HTTP requests and return HTTP
 responses. In essence, @RestController is a combination of the @Controller and @ResponseBody annotations. The @Controller
 annotation indicates that the class is a Spring MVC controller, while the @ResponseBody annotation indicates that the return
 value of each method in the controller should be serialized directly into the HTTP response body, rather than being resolved to a view.
*/
@RestController
//@RequestMapping(value = "/cus")  //General api - /cus
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // REST api's are below
    // url - "/addCustomer"
    // these 2 are post methods
    @PostMapping("/addCus")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/addCustomersDto")
    public CustomerDto addCustomerDto(@RequestBody CustomerDto customerDto){
        return customerService.saveCustomerDto(customerDto);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return customerService.saveCustomers(customers);
    }

    @GetMapping("getCus")
    public List<Customer> findAllCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customerById/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customerByName/{name}")
    public Customer findCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }
}
