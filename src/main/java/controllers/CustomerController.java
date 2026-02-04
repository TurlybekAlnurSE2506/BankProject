package controllers;

import entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.CustomerRepo;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
