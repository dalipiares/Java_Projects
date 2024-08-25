public class Parkhaus {
    int freiePlaetze;
    double preisProStunde;
    Eingangsschranke eingangsschranke;
    Ausgangsschranke ausgangsschranke;
    Kasse kasse;
    AusgabeInterface ausgabe;

    public Parkhaus(int freiePlaetze, double preisProStunde, AusgabeInterface ausgabe) {
        this.freiePlaetze = freiePlaetze;
        this.preisProStunde = preisProStunde;
        this.eingangsschranke = new Eingangsschranke();
        this.ausgangsschranke = new Ausgangsschranke();
        this.kasse = new Kasse();
        this.ausgabe = ausgabe;
    }

    public AusgabeInterface getAusgabe() {
        return ausgabe;
    }

    public Ticket ticketErstellen() {
        if (freiePlaetze > 0) {
            freiePlaetze--;
            Ticket ticket = new Ticket();
            eingangsschranke.oeffnen();
            return ticket;
        } else {
            ausgabe.printKeineFreienPlaetze();
            return null;
        }
    }

    public void platzFreigeben() {
        freiePlaetze++;
    }

    public void ticketBezahlen(Ticket ticket) {
        kasse.ticketBezahlen(ticket);
        ausgabe.printTicketBezahlt();
    }

    public void anzeigenFreiePlaetze() {
        ausgabe.printFreiePlaetze(freiePlaetze);
    }

    public double kostenBerechnen(int parkDauer) {
        return parkDauer * preisProStunde;
    }

    public void ausgangSchrankeOeffnen(Ticket ticket) {
        if (ticket.istBezahlt()) {
            ausgangsschranke.oeffnen();
            platzFreigeben();
        } else {
            ausgabe.printTicketNichtBezahlt();
        }
    }
}