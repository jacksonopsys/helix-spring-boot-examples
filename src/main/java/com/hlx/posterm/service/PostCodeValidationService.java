package com.hlx.posterm.service;

import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.dto.ValidationStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class PostCodeValidationService implements ValidationService<PostCodeInfo, ValidationStatus> {
    @Override
    public ValidationStatus validate(PostCodeInfo candidateIn) {
        String status = "invalid";
        String message = "unknown postcode";

        if(Locale.US.getCountry().equals(candidateIn.getLocale().getCountry()) &&
         candidateIn.getCode().matches("^\\d{5}(-\\d{4})?$")) {
            status = "valid";
            message = candidateIn.getLocale().toString() + " post code";
        }
        return new ValidationStatus(status,message);
    }
}
