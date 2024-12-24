package section2_4.exercise_1.item_a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import section2_4.utils.SyntaxException;

class ItemARecursiveDescentParserTest {
    public static final String[] validInputs = new String[] {
            "a",
            "+aa",
            "+a+aa",
            "-aa",
            "-a-a+aa"
    };

    public static final String[] invalidInputs = new String[] {
            "",
            "b",
            "a+a",
            "aa+",
            "a+aa",
            "-a-a",
            "a-a",
            "-a+a-a"
    };

    @Test
    void parseValidInputs() {
        for (String input : validInputs) {
            assertDoesNotThrow(() -> new ItemARecursiveDescentParser().parse(input));
        }
    }

    @Test
    void parseInvalidInputs() {
        for (String input : invalidInputs) {
            assertThrows(SyntaxException.class, () -> new ItemARecursiveDescentParser().parse(input));
        }
    }
}