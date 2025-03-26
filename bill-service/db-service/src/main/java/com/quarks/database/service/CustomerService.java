package com.quarks.database.service;

import com.quarks.database.entity.Bill;
import com.quarks.database.entity.Customer;
import com.quarks.database.repo.BillRepository;
import com.quarks.database.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final BillRepository billRepository;

    public CustomerService(CustomerRepository customerRepository, BillRepository billRepository) {
        this.customerRepository = customerRepository;
        this.billRepository = billRepository;
    }

    public void addCustomer() {
        log.info("addCustomer");
        Random random = new Random();
        int randomInt = random.nextInt();
        Customer customer = Customer.builder()
                .customerName("Customer" + randomInt)
                .emailAddress("customer" + randomInt + "@qtsolv.com")
                .phoneNumber(randomInt + "")
                .build();
        customer = customerRepository.save(customer);
        log.info("customer : {}", customer);
    }



    public List<Customer> findCustomersWithNoBillsForCurrentMonth(LocalDate startDate, LocalDate endDate) {
        log.info("findCustomersWithNoBillsForCurrentMonth");
        List<Bill> bills = billRepository.findByDueDateBetween(startDate, endDate);
        List<String> customerIds = bills.stream().map(Bill::getCustomerId).collect(Collectors.toList());
        List<Customer> customers;
        if (customerIds.isEmpty()) {
            customers = customerRepository.findAll();
        } else {
            customers = customerRepository.findExceptAllById(customerIds);
        }
        log.info("customers : {}", customers);
        return customers;
    }


    public void addBill(Bill bill) {
        log.info("addBill : {}", bill);
        billRepository.save(bill);
    }

}
