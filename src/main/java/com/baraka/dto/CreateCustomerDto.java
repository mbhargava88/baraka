package com.baraka.dto;

import com.baraka.model.AccountDetail;
import com.baraka.model.Beneficiary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerDto implements Serializable {

    private String registeredId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String contactNumber;
    private String nomineeName;
}
