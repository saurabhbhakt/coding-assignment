package com.quarks.database.repo;

import com.quarks.database.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    @Query("{'id': { '$nin': ?0 }}")
    List<Customer> findExceptAllById(List<String> customerIds);
}

