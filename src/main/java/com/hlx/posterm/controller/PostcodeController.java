package com.hlx.posterm.controller;

import com.hlx.posterm.dto.PostCodeInfo;
import com.hlx.posterm.dto.ValidationStatus;
import com.hlx.posterm.service.PostCodeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@RestController
@RequestMapping("/address")
public class PostcodeController {

    private PostCodeValidationService svc;

    @Autowired
    public PostcodeController(PostCodeValidationService svcIn) {
        svc = svcIn;
    }

    @PostMapping
    public ValidationStatus doPost(@RequestBody PostCodeInfo postCodeInfoIn) {
        return svc.validate(postCodeInfoIn);
    }

    @GetMapping("/{localeIn}/{postCodeIn}")
    public ValidationStatus doGet(@PathVariable String postCodeIn, @PathVariable String localeIn) {
        return svc.validate(PostCodeInfo.builder().locale(Locale.forLanguageTag(localeIn)).code(postCodeIn).build());
    }
}
