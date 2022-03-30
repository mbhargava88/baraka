package com.baraka.service;

import com.baraka.dto.CreateCustomerDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.model.AccountDetail;
import com.baraka.model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    Customer getCustomerById(final Long id);

    Customer createCustomerAndDefaultAccount(CreateCustomerDto createCustomerDto);

    String deleteAccountById(final Long id);

    Customer updateCustomer(final CustomerUpdateDto customerUpdateDto);

    Map<String, Object> getCustomerBalance(final Long id);

    List<AccountDetail> getCustomerAccounts(final Long id);
}
