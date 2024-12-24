package section2_4.exercise_1.item_c;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import section2_4.utils.SyntaxException;

class ItemCRecursiveDescentParserTest {
    public static final String[] validInputs = new String[] {
            "01",
            "0011",
            "000111",
            "00001111"
    };

    public static final String[] invalidInputs = new String[] {
            "",
            "0",
            "1",
            "001",
            "011",
            "00011",
            "00111",
    };

    @Test
    void parseValidInputs() {
        for (String input : validInputs) {
            assertDoesNotThrow(() -> new ItemCRecursiveDescentParser().parse(input));
        }
    }

    @Test
    void parseInvalidInputs() {
        for (String input : invalidInputs) {
            assertThrows(SyntaxException.class, () -> new ItemCRecursiveDescentParser().parse(input));
        }
    }
}