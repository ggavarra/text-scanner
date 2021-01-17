package com.dtp.digitalscanner.validation;

import com.dtp.digitalscanner.exception.DigitalScannerValidationException;

public interface Validator {
    boolean validate(String line) throws DigitalScannerValidationException;
}
