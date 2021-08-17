package com.hlx.posterm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChipInfo {
    String name;
    String number;
    String pin;
    ValidationPredilection predilection;
//    byte [][] signatureBits;
}
