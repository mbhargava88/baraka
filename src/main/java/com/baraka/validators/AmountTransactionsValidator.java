package com.baraka.validators;

import com.baraka.dto.AmountTransactionDto;
import com.baraka.exceptions.InvalidRequestException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class AmountTransactionsValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof AmountTransactionDto) {
            Map<String, String> errorsMap = new HashMap<>();
            AmountTransactionDto amountTransactionDto = (AmountTransactionDto) target;

            if (ObjectUtils.isEmpty(amountTransactionDto.getCustId())) {
                errorsMap.put("custId", "Field is required and may not be null");
            }
            if (ObjectUtils.isEmpty(amountTransactionDto.getAccountId())) {
                errorsMap.put("accountId", "Field is required and may not be null");
            }
            if (StringUtils.isBlank(amountTransactionDto.getReceiverId())) {
                errorsMap.put("receiverId", "Field is required and may not be null");
            }
            if (ObjectUtils.isEmpty(amountTransactionDto.getCurrency())) {
                errorsMap.put("currency", "Field is required and may not be null");
            }
            if (ObjectUtils.isEmpty(amountTransactionDto.getTransactionType())) {
                errorsMap.put("transactionType", "Field is required and may not be null");
            }
            if (ObjectUtils.isEmpty(amountTransactionDto.getAmountToBeUpdated())) {
                errorsMap.put("amountToBeUpdated", "Field is required and may not be null");
            }
            if (errorsMap.size() > 0) {
                errors.setErrors(errorsMap);
                throw new InvalidRequestException(errors);
            } else {
                errors.setErrors(null);
            }
        }
    }
}
