package leetcode.editor;

public class AssertException extends RuntimeException {

    public AssertException(Object expected, Object actual) {
        super(String.format("Assertion error,expected is:%s, but actual is:%s", expected, actual));
    }
}
