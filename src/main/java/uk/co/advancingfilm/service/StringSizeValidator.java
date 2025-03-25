package uk.co.advancingfilm.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StringSizeValidator implements ConstraintValidator<ByteSizeLimit, String> {

    private final int maxBytes;

    public StringSizeValidator(@Value("${app.max-bytes}") int maxBytes) {
        this.maxBytes = maxBytes;
    }

    @Override
    public boolean isValid(final String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return true;
        }

        final int byteLength = value.getBytes(StandardCharsets.UTF_8).length;
        return byteLength <= maxBytes;
    }
}
