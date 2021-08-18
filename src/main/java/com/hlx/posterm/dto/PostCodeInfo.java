package com.hlx.posterm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Locale;
@Data
@AllArgsConstructor
@Builder
public class PostCodeInfo {
    private Locale locale;
    private String code;
}
