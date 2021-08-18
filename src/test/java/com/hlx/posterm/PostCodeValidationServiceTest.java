package com.hlx.posterm;

import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.dto.ValidationStatus;
import com.hlx.posterm.service.PostCodeValidationService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;


import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Import(PostCodeValidationService.class)
@SpringBootTest
public class PostCodeValidationServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(PostCodeValidationServiceTest.class);

    @Autowired
    private PostCodeValidationService svc;

    @Test
    public void canPassGoodPostalCodeo() {
        LOG.debug("in canPassGoodpostNo");
        PostCodeInfo postCode = new PostCodeInfo(Locale.US,"62521");
        ValidationStatus status = svc.validate(postCode);
        assertEquals(status.getStatus(),"valid");
    }
}
