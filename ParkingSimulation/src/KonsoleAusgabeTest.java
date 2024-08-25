import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class KonsoleAusgabeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private KonsoleAusgabe konsoleAusgabe;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        konsoleAusgabe = new KonsoleAusgabe();
    }

    @Test
    public void printTicketErstelltPrintsCorrectOutput() {
        konsoleAusgabe.printTicketErstellt();
        assertEquals("Ticket erstellt.\n", normalize(outContent.toString()));
    }

    @Test
    public void printTicketNichtBezahltPrintsCorrectOutput() {
        konsoleAusgabe.printTicketNichtBezahlt();
        assertEquals("Ticket ist nicht bezahlt. Schranke bleibt geschlossen.\n", normalize(outContent.toString()));
    }

    @Test
    public void printAusgangPrintsCorrectOutput() {
        konsoleAusgabe.printAusgang();
        assertEquals("Simulation beendet.\n", normalize(outContent.toString()));
    }

    @Test
    public void printTicketBezahltPrintsCorrectOutput() {
        konsoleAusgabe.printTicketBezahlt();
        assertEquals("Ticket wurde bezahlt.\n", normalize(outContent.toString()));
    }

    private String normalize(String str) {
        return str.replace("\r\n", "\n");
    }
}