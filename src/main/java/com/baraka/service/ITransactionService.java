package com.baraka.service;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.model.Transactions;

public interface ITransactionService {

    Transactions performTransaction(final AmountTransactionDto amountTransactionDto);
}
