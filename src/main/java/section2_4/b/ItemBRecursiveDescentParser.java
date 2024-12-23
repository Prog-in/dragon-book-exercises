package section2_4.b;

import section2_4.utils.RecursiveDescentParser;
import section2_4.utils.SyntaxException;


/*
    Grammar parsed: S -> S(S)S | E (epsilon)
    Warning: Left-recursion that needs to be eliminated. Equivalent grammar without left-recursion:
    S -> ER
    R -> (S)SR | E
    Rewriting the first production,
    S -> R
    R -> (S)SR | E
    Hence, the first grammar is equivalent to the following:
    S -> (S)SS | E
*/
public class ItemBRecursiveDescentParser extends RecursiveDescentParser {
    public void parse(String input) {
        super.parse(input, this::S);
        checkLookAheadAfterParsing();
    }

    public void S() {
        switch (lookAhead) {
            case '(':
                match('(');
                if (lookAhead == '(') S();
                match(')');
                if (lookAhead == '(') S();
                if (lookAhead == '(') S();
                break;
            default:
                throw new SyntaxException();
        }
    }
}
