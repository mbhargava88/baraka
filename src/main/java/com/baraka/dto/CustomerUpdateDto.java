package com.baraka.dto;

import com.baraka.enums.TRANSACTION_TYPE;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerUpdateDto {

     private Long id;
     private TRANSACTION_TYPE transactionType;
     private BigDecimal amountToBeUpdated;

}
