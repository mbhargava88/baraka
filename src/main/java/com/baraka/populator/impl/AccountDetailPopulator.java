package com.baraka.populator.impl;

import com.baraka.dto.CreateAccountDetailDto;
import com.baraka.model.AccountDetail;
import com.baraka.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailPopulator implements Populator<CreateAccountDetailDto, AccountDetail> {

    @Override
    public void populate(CreateAccountDetailDto source, AccountDetail target) {

        target.setAccountType(source.getAccountType());
        target.setAvailableBalance(source.getAvailableBalance());
        target.setActive(source.isActive());
    }
}
