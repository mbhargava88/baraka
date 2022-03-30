package com.baraka.service.impl;

import com.baraka.constants.Constant;
import com.baraka.dto.AmountTransactionDto;
import com.baraka.enums.TRANSACTION_TYPE;
import com.baraka.service.IBankService;
import com.baraka.service.ITransactionService;
import com.baraka.service.ITransferService;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service will be used to perform transaction based on TRANSACTION type.
 */
@Service
@Slf4j
public class TransferService implements ITransferService {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IBankService bankService;

    /**
     * This method will update bank account for given account number with credited amt.
     * @param amountTransactionDto
     * @return
     */
    @Override
    @Synchronized
    public String performDeposit(final AmountTransactionDto amountTransactionDto) {
        amountTransactionDto.setTransactionType(TRANSACTION_TYPE.CREDIT);
        amountTransactionDto.setReceiverId(Constant.SELF);
        transactionService.performTransaction(amountTransactionDto);
        return Constant.SUCCESS;
    }

    /**
     * This method will update bank account for given account number with debited amt.
     * @param amountTransactionDto
     * @return
     */
    @Override
    @Synchronized
    public String performWithdrawl(final AmountTransactionDto amountTransactionDto) {
        amountTransactionDto.setTransactionType(TRANSACTION_TYPE.DEBIT);
        transactionService.performTransaction(amountTransactionDto);
        return Constant.SUCCESS;
    }

    /**
     * This method will update bank account & then send amt transfer request to the receiver bank.
     * @param amountTransactionDto
     * @return
     */
    @Override
    @Synchronized
    public String performTransfer(final AmountTransactionDto amountTransactionDto) {
        amountTransactionDto.setTransactionType(TRANSACTION_TYPE.DEBIT);
        transactionService.performTransaction(amountTransactionDto);
        return Constant.SUCCESS;
    }

    /**
     * This method will update bank account & then send amt transfer request to the receiver bank.
     * @param amountTransactionDto
     * @return
     */
    @Override
    @Synchronized
    public String performInternationalTransfer(final AmountTransactionDto amountTransactionDto) {
        amountTransactionDto.setTransactionType(TRANSACTION_TYPE.DEBIT);
        transactionService.performTransaction(amountTransactionDto);
        bankService.sendAmtToBank();
        return Constant.SUCCESS;
    }
}
