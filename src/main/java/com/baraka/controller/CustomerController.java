package com.baraka.controller;

import com.baraka.dto.CreateCustomerDto;
import com.baraka.model.AccountDetail;
import com.baraka.model.Customer;
import com.baraka.service.ICustomerService;
import com.baraka.validators.CustomerValidator;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api(value = "CustomerController")
@RestController
@RequestMapping("/customer")
@Validated
@Slf4j
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private Validator customerValidator;

    @ApiOperation(value = "Create Customer & Default Account")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @PostMapping(value = "/create-customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomerAndDefaultAccount(@RequestBody CreateCustomerDto createCustomerDto) {
        log.info("Action:: Create Account for emailId: {}", createCustomerDto.getEmailId());
        customerValidator.validate(createCustomerDto, new Errors());
        Customer customer = customerService.createCustomerAndDefaultAccount(createCustomerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Customer by Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/get-customer/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable Long custId) {
        log.info("Action:: Get Customer for Id: {}", custId);
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Customer")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @DeleteMapping(value = "/delete-customer/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCustomer(@PathVariable Long custId) {
        log.info("Action:: Delete Customer for Id: {}", custId);
        return new ResponseEntity<>(customerService.deleteAccountById(custId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Customer Balance by Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/get-customer-balance/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCustomerBalance(@PathVariable Long custId) {
        log.info("Action:: Get Customer Balance for Id: {}", custId);
        return new ResponseEntity<>(customerService.getCustomerBalance(custId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Customer Accounts by Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @GetMapping(value = "/get-customer-accounts/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountDetail>> getCustomerAccounts(@PathVariable Long custId) {
        log.info("Action:: Get Customer Accounts for Id: {}", custId);
        return new ResponseEntity<>(customerService.getCustomerAccounts(custId), HttpStatus.OK);
    }
}
