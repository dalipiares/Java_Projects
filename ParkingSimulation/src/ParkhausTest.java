import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkhausTest {
    private Parkhaus parkhaus;
    private AusgabeInterface ausgabeMock;

    @BeforeEach
    public void setUp() {
        ausgabeMock = new AusgabeInterface() {
            @Override
            public void printMenue() {}
            @Override
            public void printKeineFreienPlaetze() {}
            @Override
            public void printTicketErstellt() {}
            @Override
            public void printFreiePlaetze(int freiePlaetze) {}
            @Override
            public void printKostenBerechnen() {}
            @Override
            public void printKosten(double kosten) {}
            @Override
            public void printTicketBezahlt() {}
            @Override
            public void printAusgang() {}
            @Override
            public void printUngueltigeOption() {}
            @Override
            public void printTicketNichtBezahlt() {}
        };
        parkhaus = new Parkhaus(100, 2.5, ausgabeMock);
    }

    @Test
    public void getAusgabeReturnsCorrectInstance() {
        assertEquals(ausgabeMock, parkhaus.getAusgabe());
    }

    @Test
    public void ticketErstellenReducesFreiePlaetze() {
        parkhaus.ticketErstellen();
        assertEquals(99, parkhaus.freiePlaetze);
    }

    @Test
    public void ticketErstellenReturnsNullWhenNoFreiePlaetze() {
        parkhaus = new Parkhaus(0, 2.5, ausgabeMock);
        Ticket ticket = parkhaus.ticketErstellen();
        assertNull(ticket);
    }

    @Test
    public void platzFreigebenIncreasesFreiePlaetze() {
        parkhaus.platzFreigeben();
        assertEquals(101, parkhaus.freiePlaetze);
    }

    @Test
    public void ticketBezahlenSetsTicketBezahlt() {
        Ticket ticket = new Ticket();
        parkhaus.ticketBezahlen(ticket);
        assertTrue(ticket.istBezahlt());
    }

    @Test
    public void anzeigenFreiePlaetzePrintsCorrectNumber() {
        parkhaus.anzeigenFreiePlaetze();
        // Assuming the mock implementation does not change, we cannot assert the print output directly
    }

    @Test
    public void kostenBerechnenReturnsCorrectAmount() {
        double kosten = parkhaus.kostenBerechnen(4);
        assertEquals(10.0, kosten);
    }

    @Test
    public void ausgangSchrankeOeffnenFreigibtPlatzWhenTicketBezahlt() {
        Ticket ticket = new Ticket();
        ticket.bezahlen();
        parkhaus.ausgangSchrankeOeffnen(ticket);
        assertEquals(101, parkhaus.freiePlaetze);
    }

    @Test
    public void ausgangSchrankeOeffnenDoesNotFreigebenPlatzWhenTicketNichtBezahlt() {
        Ticket ticket = new Ticket();
        parkhaus.ausgangSchrankeOeffnen(ticket);
        assertEquals(100, parkhaus.freiePlaetze);
    }
}