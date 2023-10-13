import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DecoderTest {

    @Test
    public void testDecodeVowels() {
        assertEquals("testing", Decoder.decodeVowels("t2st3ng"));
        assertEquals("hello", Decoder.decodeVowels("h2llo"));
    }

    @Test
    public void testDecodeConsonants() {
        assertEquals("testing", Decoder.decodeConsonants("ufttjoh"));
        assertEquals("world", Decoder.decodeConsonants("xpsme"));
    }

    @Test
    public void testDecode() {
        assertEquals("testing", Decoder.decode("t2st3ng"));
        assertEquals("hello world", Decoder.decode("h2llo w4rld"));
    }

    @Test
    public void testDecodeWithMixedEncoding() {
        assertEquals("testing hello", Decoder.decode("t2st3ng h2llo"));
        assertEquals("12345", Decoder.decode("1bcde 23"));
    }
}
