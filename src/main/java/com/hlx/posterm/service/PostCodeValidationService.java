package com.hlx.posterm.service;

import com.hlx.posterm.dto.ValidationStatus;
import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.model.PostcodeData;
import com.hlx.posterm.repository.PostcodeCRUDReporitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Locale;

@Service
public class PostCodeValidationService implements ValidationService<PostCodeInfo, ValidationStatus> {
    private static final Logger LOG = LoggerFactory.getLogger(PostCodeValidationService.class);
    @Autowired
    private PostcodeCRUDReporitory repo;

    @Override
    public ValidationStatus validate(PostCodeInfo candidateIn) {
        String status = "invalid";
        String message = "unknown postcode";
        repo.save(PostcodeData.builder()
                        .postCode(candidateIn.getLocale().toString())
                        .postCode(candidateIn.getCode())
                        .build());
        if(Locale.US.getCountry().equals(candidateIn.getLocale().getCountry()) &&
         candidateIn.getCode().matches("^\\d{5}(-\\d{4})?$")) {
            status = "valid";
            message = candidateIn.getLocale().toString() + " post code";
        }
        long rows = repo.count();
        LOG.info(rows + " rows in the query table");

        return new ValidationStatus(status,message);
    }
}
