package com.baraka.service.impl;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.dto.CustomerUpdateDto;
import com.baraka.enums.TRANSACTION_STATUS;
import com.baraka.model.Transactions;
import com.baraka.repository.TransactionRepository;
import com.baraka.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private IAccountDetailService accountDetailService;

    @Override
    @Transactional
    public Transactions performTransaction(final AmountTransactionDto amountTransactionDto) {
        Transactions transactions = Transactions.builder()
                .status(TRANSACTION_STATUS.SUCCESS)
                .amount(amountTransactionDto.getAmountToBeUpdated())
                .customerId(amountTransactionDto.getCustId())
                .currency(amountTransactionDto.getCurrency())
                .receivedId(amountTransactionDto.getReceiverId().toString())
                .type(amountTransactionDto.getTransactionType())
                .build();
            accountDetailService.updateAccountBalanceById(amountTransactionDto);
            return transactionRepository.save(transactions);
    }
}
