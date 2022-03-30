package com.baraka.dto;

import com.baraka.enums.ACCOUNT_TYPE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountDetailDto {

    ACCOUNT_TYPE accountType;
    BigDecimal availableBalance;
    boolean active;
}
