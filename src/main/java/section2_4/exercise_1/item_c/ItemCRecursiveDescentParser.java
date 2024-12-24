package section2_4.exercise_1.item_c;

import section2_4.utils.RecursiveDescentParser;
import section2_4.utils.SyntaxException;


/*
    Grammar parsed: S -> 0S1 | 01
*/
public class ItemCRecursiveDescentParser extends RecursiveDescentParser {
    public void parse(String input) {
        super.parse(input, this::S);
    }

    public void S() {
        switch (lookAhead) {
            case '0':
                match('0');
                if (lookAhead == '0') S();
                match('1');
                break;
            default:
                throw new SyntaxException();
        }
    }
}
