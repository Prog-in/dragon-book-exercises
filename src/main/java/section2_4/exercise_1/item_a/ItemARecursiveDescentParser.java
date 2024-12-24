package section2_4.exercise_1.item_a;

import section2_4.utils.RecursiveDescentParser;
import section2_4.utils.SyntaxException;


/*
    Grammar parsed: S -> +SS | -SS | a
*/
public class ItemARecursiveDescentParser extends RecursiveDescentParser {
    public void parse(String input) {
        super.parse(input, this::S);
    }

    public void S() {
        switch (lookAhead) {
            case '+':
                match('+');
                S();
                S();
                break;
            case '-':
                match('-');
                S();
                S();
                break;
            case 'a':
                match('a');
                break;
            default:
                throw new SyntaxException();
        }
    }
}
