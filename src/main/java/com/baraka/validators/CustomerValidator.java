package com.baraka.validators;

import com.baraka.dto.CreateCustomerDto;
import com.baraka.exceptions.InvalidRequestException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Create customer Validator
 */
@Component
public class CustomerValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        if(target instanceof CreateCustomerDto) {
            Map<String, String> errorsMap = new HashMap<>();
            CreateCustomerDto createCustomerDto = (CreateCustomerDto) target;

            if(StringUtils.isBlank(createCustomerDto.getRegisteredId())){
                errorsMap.put("registeredId", "Field is required and may not be null");
            }
            if(StringUtils.isBlank(createCustomerDto.getFirstName())){
                errorsMap.put("firstName", "Field is required and may not be null");
            }
            if(StringUtils.isBlank(createCustomerDto.getLastName())){
                errorsMap.put("lastName", "Field is required and may not be null");
            }
            if(StringUtils.isBlank(createCustomerDto.getEmailId())){
                errorsMap.put("emailId", "Field is required and may not be null");
            }
            if(StringUtils.isBlank(createCustomerDto.getContactNumber())){
                errorsMap.put("contactNumber", "Field is required and may not be null");
            }
            if(errorsMap.size() > 0){
                errors.setErrors(errorsMap);
                throw new InvalidRequestException(errors);
            }else{
                errors.setErrors(null);
            }
        }
    }
}
