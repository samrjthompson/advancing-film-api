package uk.co.advancingfilm.service;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StringSizeValidator {

    private final int maxBytes;

    public StringSizeValidator(@Value("${app.max-bytes}") int maxBytes) {
        this.maxBytes = maxBytes;
    }

    public boolean isValidString(final String value) {
        if (!StringUtils.hasText(value)) {
            return true;
        }

        final int byteLength = value.getBytes(StandardCharsets.UTF_8).length;
        return byteLength <= maxBytes;
    }
}
