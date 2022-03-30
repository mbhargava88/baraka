package com.baraka.repository;

import com.baraka.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to perform CRUD operations on {@link Customer} entity.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
