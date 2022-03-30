package com.baraka.util;

import com.baraka.dto.ErrorResponseDto;
import com.baraka.enums.TRANSACTION_TYPE;
import com.baraka.exceptions.InsufficientFundException;

import java.math.BigDecimal;

public class CalculationUtil {

    public static BigDecimal getRevisedAmt(BigDecimal currentAmt, BigDecimal amtToBeUpdated, TRANSACTION_TYPE type){
        BigDecimal revisedAmt = null;
        if(TRANSACTION_TYPE.CREDIT.equals(type)){
            revisedAmt = currentAmt.add(amtToBeUpdated).setScale(2, BigDecimal.ROUND_CEILING);
        }else if(TRANSACTION_TYPE.DEBIT.equals(type)){
            if(currentAmt.compareTo(amtToBeUpdated) < 0){
                throw new InsufficientFundException();
            }else{
                revisedAmt = currentAmt.subtract(amtToBeUpdated).setScale(2, BigDecimal.ROUND_CEILING);
            }
        }
        return revisedAmt;
    }
}
