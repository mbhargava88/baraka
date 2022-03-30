package com.baraka.populator.impl;

import com.baraka.dto.CreateCustomerDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.model.Customer;
import com.baraka.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class CustomerPopulator implements Populator<CreateCustomerDto, Customer> {

    @Override
    public void populate(CreateCustomerDto source, Customer target) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmailId(source.getEmailId());
        target.setRegisteredGovernmentId(source.getRegisteredId());
        target.setContactNumber(source.getContactNumber());
    }
}
