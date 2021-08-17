package com.hlx.posterm.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ValidationStatus {
    String timeStamp;
    String status;
    String message;
}
