import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.digiteched.javadsa.applications.TextProcessor;

public class ReverseTest {

    @Test
    public void allLowercase() {
        String stringToReverse = "hello this string will become reversed";
        String expected = "desrever emoceb lliw gnirts siht olleh";

        assertEquals(expected, TextProcessor.reverse(stringToReverse));
    }

    @Test
    public void mixedCase() {
        String stringToReverse = "Cat in The Hat";
        String expected = "taH ehT ni taC";

        assertEquals(expected, TextProcessor.reverse(stringToReverse));
    }

    @Test
    public void specialChacters() {
        String stringToReverse = "Hello there! Did you know how much $ Iron Man(2008) made world wide? $584,877,827!";
        String expected = "!728,778,485$ ?ediw dlrow edam )8002(naM norI $ hcum woh wonk uoy diD !ereht olleH";
        // Why did I make this so long? this was a pain to figure out

        assertEquals(expected, TextProcessor.reverse(stringToReverse));
    }
}
