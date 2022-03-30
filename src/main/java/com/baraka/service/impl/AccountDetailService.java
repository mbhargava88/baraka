package com.baraka.service.impl;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.dto.CreateAccountDetailDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.exceptions.RecordNotFoundException;
import com.baraka.model.AccountDetail;
import com.baraka.populator.Populator;
import com.baraka.repository.AccountDetailRepository;
import com.baraka.service.IAccountDetailService;
import com.baraka.util.CalculationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AccountDetailService implements IAccountDetailService {

    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @Autowired
    private Populator<CreateAccountDetailDto, AccountDetail> accountDetailPopulator;

    @Override
    public AccountDetail getAccountById(Long id) {

        Optional<AccountDetail> accountDetailOptional = accountDetailRepository.findById(id);
        if(!accountDetailOptional.isPresent()){
            throw new RecordNotFoundException();
        }
        return accountDetailOptional.get();
    }

    @Override
    public AccountDetail createAccount(CreateAccountDetailDto createAccountDetailDto) {
        AccountDetail accountDetail = AccountDetail.builder().build();
        accountDetailPopulator.populate(createAccountDetailDto, accountDetail);
        accountDetail = accountDetailRepository.save(accountDetail);
        return accountDetail;
    }

    @Override
    public AccountDetail updateAccountBalanceById(final AmountTransactionDto amountTransactionDto) {
        AccountDetail accountDetail = getAccountById(amountTransactionDto.getAccountId());

        accountDetail.setAvailableBalance(CalculationUtil.getRevisedAmt(
                accountDetail.getAvailableBalance(), amountTransactionDto.getAmountToBeUpdated(),
                amountTransactionDto.getTransactionType()
        ));
        return accountDetailRepository.save(accountDetail);
    }
}
