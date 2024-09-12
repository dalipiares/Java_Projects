import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Parkhaus {
    int freiePlaetze;
    double preisProStunde;
    Consumer<Void> eingangsschrankeOeffnen;
    Consumer<Void> ausgangsschrankeOeffnen;
    Consumer<Ticket> ticketBezahlen;
    AusgabeInterface ausgabe;

    public Parkhaus(int freiePlaetze, double preisProStunde, AusgabeInterface ausgabe,
                    Consumer<Void> eingangsschrankeOeffnen, Consumer<Void> ausgangsschrankeOeffnen,
                    Consumer<Ticket> ticketBezahlen) {
        this.freiePlaetze = freiePlaetze;
        this.preisProStunde = preisProStunde;
        this.ausgabe = ausgabe;
        this.eingangsschrankeOeffnen = eingangsschrankeOeffnen;
        this.ausgangsschrankeOeffnen = ausgangsschrankeOeffnen;
        this.ticketBezahlen = ticketBezahlen;
    }

    public AusgabeInterface getAusgabe() {
        return ausgabe;
    }

    public Supplier<Ticket> ticketErstellen() {
        return () -> {
            if (freiePlaetze > 0) {
                freiePlaetze--;
                Ticket ticket = new Ticket();
                eingangsschrankeOeffnen.accept(null);
                return ticket;
            } else {
                ausgabe.printKeineFreienPlaetze();
                return null;
            }
        };
    }

    public Runnable platzFreigeben() {
        return () -> freiePlaetze++;
    }

    public Consumer<Ticket> ticketBezahlen() {
        return ticket -> {
            ticketBezahlen.accept(ticket);
            ausgabe.printTicketBezahlt();
        };
    }

    public Runnable anzeigenFreiePlaetze() {
        return () -> ausgabe.printFreiePlaetze(freiePlaetze);
    }

    public Function<Integer, Double> kostenBerechnen() {
        return parkDauer -> parkDauer * preisProStunde;
    }

    public Consumer<Ticket> ausgangSchrankeOeffnen() {
        return ticket -> {
            if (ticket.istBezahlt()) {
                ausgangsschrankeOeffnen.accept(null);
                platzFreigeben().run();
            } else {
                ausgabe.printTicketNichtBezahlt();
            }
        };
    }
}