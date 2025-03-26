package com.quarks.database.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class BillCalculationScheduler {

    private static final Logger log = LoggerFactory.getLogger(BillCalculationScheduler.class);
    private final CustomerService customerService;
    private final DbProducerService dbProducerService;

    public BillCalculationScheduler(CustomerService customerService, DbProducerService dbProducerService) {
        this.customerService = customerService;
        this.dbProducerService = dbProducerService;
    }

    @Scheduled(fixedRate = 10000)
    public void sendToCalculateBills(){
        log.info("calculate Bills");
        dbProducerService.sendToCalculateBills();
    }

    @Scheduled(fixedRate = 2000)
    public void addNewCustomer(){
        log.info("getDataFromDbService");
        customerService.addCustomer();
    }

}
