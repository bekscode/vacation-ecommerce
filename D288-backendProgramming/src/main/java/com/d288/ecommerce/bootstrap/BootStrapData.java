package com.d288.ecommerce.bootstrap;

import com.d288.ecommerce.dao.CustomerRepository;
import com.d288.ecommerce.dao.DivisionRepository;
import com.d288.ecommerce.entities.Customer;
import com.d288.ecommerce.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Check if customers are already saved in the database
        if (customerRepository.count() == 1) {

        // Sample customers
        Customer joe = new Customer("Joe", "Schmoe", "321 Walnut Street", "95123", "6784189537");
        joe.setDivision(divisionRepository.findAll().get(3));

        Customer max = new Customer("Max", "Mustermann", "678 Birch Blvd", "26493", "7269815501");
        max.setDivision(divisionRepository.findAll().get(5));

        Customer hong = new Customer("Hong", "Gildong", "456 Lake Drive", "24810", "9023814908");
        hong.setDivision(divisionRepository.findAll().get(6));

        Customer sam = new Customer("Sam", "Student", "707 Home Street", "61392", "4173296612");
        sam.setDivision(divisionRepository.findAll().get(7));

        Customer mary = new Customer("Mary", "Murphy", "1421 Old Town Road", "54321", "6135024707");
        mary.setDivision(divisionRepository.findAll().get(8));

        // Save the customers to the database
        customerRepository.save(joe);
        customerRepository.save(max);
        customerRepository.save(hong);
        customerRepository.save(sam);
        customerRepository.save(mary);

        // Display message depending on if customers were added or already present
            System.out.println("Customers saved to database!");
        } else {
            System.out.println("Customers already saved!");
        }

    }
}
