package com.springsec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsec.model.Customer;
import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
  List<Customer> findByEmail(String email);
}
