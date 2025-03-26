package com.quarks.database.repo;

import com.quarks.database.entity.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
}
