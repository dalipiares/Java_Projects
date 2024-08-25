import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("1\n2\n3\n4\n5\n6\n".getBytes());

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @Test
    public void testMain() {
        Main.main(new String[]{});
        String output = normalize(outContent.toString());
        assertTrue(output.contains("1. Parkhaus betreten (Ticket erstellen)"));
        assertTrue(output.contains("2. Freie Plätze anzeigen"));
        assertTrue(output.contains("3. Parkkosten berechnen"));
        assertTrue(output.contains("4. Ticket bezahlen"));
        assertTrue(output.contains("5. Parkhaus verlassen (Ausgangsschranke öffnen)"));
        assertTrue(output.contains("6. Beenden"));
    }

    private String normalize(String str) {
        return str.replace("\r\n", "\n");
    }
}