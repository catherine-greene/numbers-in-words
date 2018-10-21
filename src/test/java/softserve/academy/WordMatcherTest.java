package softserve.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WordMatcherTest {

    @Test
    void testMatchThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> WordMatcher.match(-1));
    }
}
