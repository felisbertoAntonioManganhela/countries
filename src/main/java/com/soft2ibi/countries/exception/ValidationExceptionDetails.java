package com.soft2ibi.countries.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ErrorDetails {
    private final String fields;
}
