package leetcode.editor;

import java.util.Objects;

public final class Assertions {
    private Assertions() {

    }

    public static void isEqual(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertException(expected, actual);
        }
    }

    public static void isTrue(Boolean v) {
        if (!Boolean.TRUE.equals(v)) {
            throw new AssertException(true, v);
        }
    }

    public static void isFalse(Boolean v) {
        if (!Boolean.FALSE.equals(v)) {
            throw new AssertException(false, v);
        }
    }
}

