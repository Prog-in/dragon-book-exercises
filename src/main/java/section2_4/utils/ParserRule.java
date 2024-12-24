package section2_4.utils;

@FunctionalInterface
public interface ParserRule {
    void run() throws SyntaxException;
}
