package com.soft2ibi.countries.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ErrorDetails {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
}
