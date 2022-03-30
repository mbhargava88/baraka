package com.baraka.service.impl;

import com.baraka.dto.CreateCustomerDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.enums.ACCOUNT_TYPE;
import com.baraka.enums.CURRENCY;
import com.baraka.exceptions.RecordNotFoundException;
import com.baraka.model.AccountDetail;
import com.baraka.model.Customer;
import com.baraka.populator.Populator;
import com.baraka.repository.CustomerRepository;
import com.baraka.service.IAccountDetailService;
import com.baraka.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * This service will handle all operations related to customer account.
 */
@Service
@Slf4j
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private IAccountDetailService accountDetailService;

    @Autowired
    private Populator<CreateCustomerDto, Customer> customerPopulator;

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(!customerOptional.isPresent()){
            throw new RecordNotFoundException();
        }
        return customerOptional.get();
    }

    @Override
    @Transactional
    public Customer createCustomerAndDefaultAccount(CreateCustomerDto createCustomerDto) {

        //Create default savings account along with customer creation.
        AccountDetail accountDetail = AccountDetail.builder()
                .accountType(ACCOUNT_TYPE.SAVINGS)
                .availableBalance(new BigDecimal("200"))
                .currency(CURRENCY.AED).build();

        Customer customer = Customer.builder()
                .accountDetails(Arrays.asList(accountDetail))
                .build();

        customerPopulator.populate(createCustomerDto, customer);
        customer = customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerUpdateDto customerUpdateDto) {
        Customer customer = getCustomerById(customerUpdateDto.getId());
        return customerRepository.save(customer);
    }

    @Override
    public String deleteAccountById(Long id) {
        customerRepository.deleteById(id);
        return "SUCCESS";
    }

    @Override
    public Map<String, Object> getCustomerBalance(Long id) {

        Map<String, Object> response = new HashMap<>();
        AtomicReference<BigDecimal> total = new AtomicReference<>(new BigDecimal(0));
        Customer customer = getCustomerById(id);
        customer.getAccountDetails().stream().forEach(a -> {
           total.set(total.get().add(a.getAvailableBalance()));
        });
        response.put("custId", id);
        response.put("totalBalance",total.get());
        return response;
    }

    @Override
    public List<AccountDetail> getCustomerAccounts(Long id) {
        Customer customer = getCustomerById(id);
        return customer.getAccountDetails();
    }
}
