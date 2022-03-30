package com.baraka.service;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.model.Transactions;

public interface ITransferService {

    String performDeposit(final AmountTransactionDto amountTransactionDto);
    String performWithdrawl(final AmountTransactionDto amountTransactionDto);
    String performTransfer(final AmountTransactionDto amountTransactionDto);
    String performInternationalTransfer(final AmountTransactionDto amountTransactionDto);
}
