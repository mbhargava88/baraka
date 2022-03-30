package com.baraka.service.impl;

import com.baraka.service.IBankService;
import com.baraka.service.ICurrencyConversionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service will be used to integrate other bank services
 */
@Service
@Slf4j
public class BankService implements IBankService {

    @Autowired
    private ICurrencyConversionService currencyConversionService;

    @Override
    public void sendAmtToBank() {
        //TODO it can be used to integrate with respective bank services to send money.
    }
}
