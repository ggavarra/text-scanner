package com.dtp.digitalscanner.validation;


import com.dtp.digitalscanner.exception.DigitalScannerValidationException;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor
public class BaseValidator implements Validator {
    private final int STRING_MAX_LENGTH = 27;

    public boolean validate(String line) throws DigitalScannerValidationException {
        if (!StringUtils.isBlank(line) && line.length() < STRING_MAX_LENGTH)
            throw new DigitalScannerValidationException("String length expected to be " + STRING_MAX_LENGTH + " but found " + line.length());

        return true;
    }

}
