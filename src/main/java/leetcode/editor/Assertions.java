package leetcode.editor;

import java.util.Objects;

public final class Assertions {
    private Assertions() {

    }

    public static void isEqual(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertException(expected,actual);
        }
    }
}

