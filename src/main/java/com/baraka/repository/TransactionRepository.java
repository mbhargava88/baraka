package com.baraka.repository;

import com.baraka.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to perform CRUD operations on {@link Transactions} entity.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transactions, Long> {
}
