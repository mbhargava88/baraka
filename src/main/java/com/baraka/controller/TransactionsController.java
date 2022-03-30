package com.baraka.controller;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.service.ITransferService;
import com.baraka.validators.Errors;
import com.baraka.validators.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "TransactionsController")
@RestController
@RequestMapping("/transactions")
@Validated
@Slf4j
public class TransactionsController {

    @Autowired
    private ITransferService transferService;

    @Autowired
    private Validator amountTransactionsValidator;

    @ApiOperation(value = "Deposit Amount into Customer Account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping(value = "/deposit-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> depositAmount(@RequestBody AmountTransactionDto amountTransactionDto) {
        log.info("Action:: Deposit Amount for custId: {} and accountId: {}",
                amountTransactionDto.getCustId(), amountTransactionDto.getAccountId());

        amountTransactionsValidator.validate(amountTransactionDto, new Errors());
        return new ResponseEntity<>(transferService.performDeposit(amountTransactionDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Withdrawl Amount from Customer Account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping(value = "/withdrawl-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> withdrawlAmount(@RequestBody AmountTransactionDto amountTransactionDto) {

        log.info("Action:: Withdrawl Amount for custId: {} and accountId: {}",
                amountTransactionDto.getCustId(), amountTransactionDto.getAccountId());
        amountTransactionsValidator.validate(amountTransactionDto, new Errors());
        return new ResponseEntity<>(transferService.performWithdrawl(amountTransactionDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Transfer Amount from Customer Account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping(value = "/transfer-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> transferAmount(@RequestBody AmountTransactionDto amountTransactionDto) {

        log.info("Action:: Transfer Amount for custId: {} and accountId: {}",
                amountTransactionDto.getCustId(), amountTransactionDto.getAccountId());
        amountTransactionsValidator.validate(amountTransactionDto, new Errors());
        return new ResponseEntity<>(transferService.performTransfer(amountTransactionDto), HttpStatus.OK);
    }

    @ApiOperation(value = "International Transfer Amount from Customer Account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping(value = "/international-transfer-amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> internationalTransferAmount(@RequestBody AmountTransactionDto amountTransactionDto) {

        log.info("Action:: International Transfer Amount for custId: {} and accountId: {}",
                amountTransactionDto.getCustId(), amountTransactionDto.getAccountId());
        amountTransactionsValidator.validate(amountTransactionDto, new Errors());
        return new ResponseEntity<>(transferService.performInternationalTransfer(amountTransactionDto), HttpStatus.OK);
    }
}
