package com.baraka.repository;

import com.baraka.model.AccountDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to perform CRUD operations on {@link AccountDetail} entity.
 */
@Repository
public interface AccountDetailRepository extends CrudRepository<AccountDetail, Long> {

}
