package uk.co.advancingfilm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringSizeValidatorTest {

    private final StringSizeValidator stringSizeValidator = new StringSizeValidator(120000);

    @ParameterizedTest
    @CsvSource({
            "119999 , true",
            "120000 , true",
            "120001 , false"
    })
    void shouldValidateStringSize(final int count, final boolean expected) {
        // given
        final String input = "a".repeat(count);

        // when
        final boolean actual = stringSizeValidator.isValidString(input);

        // then
        assertEquals(expected, actual);
        assertEquals(input.getBytes(StandardCharsets.UTF_8).length, count);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "null",
            "''"
    }, nullValues = "null")
    void shouldReturnTrueIfStringIsNullOrEmpty(final String input) {
        assertTrue(stringSizeValidator.isValidString(input));
    }
}
