import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    @Test
    public void ticketIsNotBezahltInitially() {
        Ticket ticket = new Ticket();
        assertFalse(ticket.istBezahlt());
    }

    @Test
    public void bezahlenSetsTicketBezahlt() {
        Ticket ticket = new Ticket();
        ticket.bezahlen();
        assertTrue(ticket.istBezahlt());
    }
}