import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KasseTest {
    @Test
    public void ticketBezahlenSetsTicketBezahlt() {
        Ticket ticket = new Ticket();
        Kasse kasse = new Kasse();
        kasse.ticketBezahlen(ticket);
        assertTrue(ticket.istBezahlt());
    }
}