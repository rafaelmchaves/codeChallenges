package repeatedstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatedStringTest {

    @Test
    public void getQuantityOfa_abaRepeated10Times_Return7as() {

        var occurrenciesOfa = RepeatedString.getQuantityOfa("aba", 10);

        Assertions.assertEquals(7, occurrenciesOfa);
    }

    @Test
    public void getQuantityOfa_abcacRepeated10Times_Return4as() {

        var occurrenciesOfa = RepeatedString.getQuantityOfa("abcac", 10);

        Assertions.assertEquals(4, occurrenciesOfa);
    }

    @Test
    public void getQuantityOfa_aRepeated1000000000000Times_Return4as() {

        var occurrenciesOfa = RepeatedString.getQuantityOfa("a", 1000000000000L);

        Assertions.assertEquals(1000000000000L, occurrenciesOfa);
    }

    @Test
    public void getQuantityOfa_EmptyString_Return0as() {

        var occurrenciesOfa = RepeatedString.getQuantityOfa("", 10);

        Assertions.assertEquals(0, occurrenciesOfa);
    }

    @Test
    public void getQuantityOfa_NullString_Return0as() {

        var occurrenciesOfa = RepeatedString.getQuantityOfa(null, 10);

        Assertions.assertEquals(0, occurrenciesOfa);
    }

}
