package section2_4.exercise_1.item_b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import section2_4.utils.SyntaxException;

class ItemBRecursiveDescentParserTest {
    public static final String[] validInputs = new String[] {
            "()",
            "()()()",
            "(((())))",
            "(()()())",
            "(())(()())"
    };

    public static final String[] invalidInputs = new String[] {
            "",
            "(",
            ")",
            "()(",
            "((())",
            "(())))",
            "b"
    };

    @Test
    void parseValidInputs() {
        for (String input : validInputs) {
            assertDoesNotThrow(() -> new ItemBRecursiveDescentParser().parse(input));
        }
    }

    @Test
    void parseInvalidInputs() {
        for (String input : invalidInputs) {
            assertThrows(SyntaxException.class, () -> new ItemBRecursiveDescentParser().parse(input));
        }
    }
}