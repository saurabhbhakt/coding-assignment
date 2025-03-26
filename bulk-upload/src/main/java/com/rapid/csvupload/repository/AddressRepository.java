package com.rapid.csvupload.repository;

import com.rapid.csvupload.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}