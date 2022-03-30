package com.baraka.dto;

import com.baraka.enums.CURRENCY;
import com.baraka.enums.TRANSACTION_TYPE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmountTransactionDto implements Serializable{

    private Long custId;
    private Long accountId;
    private String receiverId;
    private CURRENCY currency;
    private TRANSACTION_TYPE transactionType;
    private BigDecimal amountToBeUpdated;
}
