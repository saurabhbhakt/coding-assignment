package com.rapid.csvupload.service;

import com.opencsv.CSVReader;
import com.rapid.csvupload.entity.Address;
import com.rapid.csvupload.entity.Employee;
import com.rapid.csvupload.repository.AddressRepository;
import com.rapid.csvupload.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

@Service
@Slf4j
public class CSVService {

    public static final int BATCH_SIZE = 10; // Adjust as per performance tests
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ExecutorService executor = Executors.newFixedThreadPool(4); // Parallel execution

    public CSVService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void saveEmployeesFromCSV(MultipartFile file) {
        log.info("file Name  : {}", file.getOriginalFilename());
        try {
            List<Map<String, String>> records = readCsvAsMap(file);
            List<Employee> employees = new ArrayList<>();
            List<Address> addresses = new ArrayList<>();

            for (Map<String, String> record : records) {
                addCsvRecord(record, employees, addresses);
            }
            log.info("saveEmployeesFromCSV :  records size {}", employees.size());
            // Partition the data into batches
            List<List<Employee>> employeeBatches = partitionList(employees);
            List<List<Address>> addressBatches = partitionList(addresses);

            bulkUpload(employeeBatches, addressBatches);

        } catch (Exception e) {
            log.error("Error processing CSV file: {}", e.getMessage(), e);
            throw new RuntimeException("Error processing CSV file: " + e.getMessage());
        }
    }

    private void bulkUpload(List<List<Employee>> employeeBatches, List<List<Address>> addressBatches) throws InterruptedException, ExecutionException {
        log.info("bulkUpload size : {}", employeeBatches.size());
        if (employeeBatches.size() != addressBatches.size()) {
            throw new IllegalArgumentException("Mismatch in batch sizes between employees and addresses.");
        }
        List<Future<Void>> futures = new ArrayList<>();
        Iterator<List<Employee>> employeeIterator = employeeBatches.iterator();
        Iterator<List<Address>> addressIterator = addressBatches.iterator();
        while (employeeIterator.hasNext() && addressIterator.hasNext()){
            List<Employee> employeeBatch = employeeIterator.next();
            List<Address> addressBatch = addressIterator.next();
            futures.add(executor.submit(() -> {
                bulkInsert(employeeBatch, addressBatch);
                return null;
            }));
        }
        // Wait for all tasks to complete
        for (Future<Void> future : futures) {
            future.get();
        }
    }

    public List<Map<String, String>> readCsvAsMap(MultipartFile file) throws Exception {
        List<Map<String, String>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] headers = csvReader.readNext(); // Read header
            log.info("File headers : {}", (Object) headers);
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], line[i]);
                }
                records.add(record);
            }
        }
        return records;
    }

    private static void addCsvRecord(Map<String, String> record, List<Employee> employees, List<Address> addresses) {
        Employee employee = Employee.builder()
                .name(record.get("Name"))
                .email(record.get("Email"))
                .phone(record.get("Phone"))
                .build();

        Address address = Address.builder()
                .street(record.get("Street"))
                .city(record.get("City"))
                .state(record.get("State"))
                .zipCode(record.get("ZipCode"))
                .build();

        address.setEmployee(employee);
        employee.setAddress(address);
        employees.add(employee);
        addresses.add(address);
    }

    private void bulkInsert(List<Employee> employees, List<Address> addresses) {
        log.info("bulkInsert :  batch size {}", employees.size());
        employeeRepository.saveAll(employees); // Bulk insert employees
        addressRepository.saveAll(addresses);   // Bulk insert addresses
    }

    private static <T> List<List<T>> partitionList(List<T> list) {
        List<List<T>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += CSVService.BATCH_SIZE) {
            partitions.add(list.subList(i, Math.min(i + CSVService.BATCH_SIZE, list.size())));
        }
        return partitions;
    }
}
