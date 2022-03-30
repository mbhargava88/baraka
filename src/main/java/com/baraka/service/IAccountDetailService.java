package com.baraka.service;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.dto.CreateAccountDetailDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.model.AccountDetail;

public interface IAccountDetailService {

    AccountDetail getAccountById(final Long id);

    AccountDetail createAccount(CreateAccountDetailDto createAccountDetailDto);

    AccountDetail updateAccountBalanceById(final AmountTransactionDto amountTransactionDto);
}
