package section2_4.utils;

public class RecursiveDescentParser {
    protected String input;
    protected Character lookAhead;
    protected int lookAheadIndex;

    protected void parse(String input, Runnable startSymbol) {
        if (input.isEmpty()) {
            throw new SyntaxException();
        }
        this.input = input;
        updateLookAhead(0);

        startSymbol.run();
    }

    protected boolean hasNonParsedSymbols() {
        return lookAheadIndex < input.length();
    }

    protected void updateLookAhead(int index) {
        lookAheadIndex = index;
        if (hasNonParsedSymbols()) {
            lookAhead = input.charAt(lookAheadIndex);
        } else {
            lookAhead = 0; // dummy char that doesn't belong to the terminal charset of the grammar
        }
    }

    protected void updateLookAhead() {
        updateLookAhead(lookAheadIndex + 1);
    }

    protected void checkLookAheadAfterParsing() {
        if (hasNonParsedSymbols()) {
            throw new SyntaxException();
        }
    }

    protected void match(char token) {
        if (lookAhead != token) {
            throw new SyntaxException();
        }
        updateLookAhead();
    }
}
