public class Parkhaus {
    int freiePlaetze;
    double preisProStunde;
    Eingangsschranke eingangsschranke;
    Ausgangsschranke ausgangsschranke;
    Kasse kasse;

    public Parkhaus(int freiePlaetze, double preisProStunde) {
        this.freiePlaetze = freiePlaetze;
        this.preisProStunde = preisProStunde;
        this.eingangsschranke = new Eingangsschranke();
        this.ausgangsschranke = new Ausgangsschranke();
        this.kasse = new Kasse();
    }

    public Ticket ticketErstellen() {
        if (freiePlaetze > 0) {
            freiePlaetze--;
            Ticket ticket = new Ticket();
            eingangsschranke.oeffnen();
            return ticket;
        } else {
            System.out.println("Keine freien Plätze verfügbar.");
            return null;
        }
    }

    public void ticketBezahlen(Ticket ticket) {
        kasse.ticketBezahlen(ticket);
    }

    public void anzeigenFreiePlaetze() {
        System.out.println("Freie Plätze: " + freiePlaetze);
    }

    public double kostenBerechnen(int parkDauer) {
        return parkDauer * preisProStunde;
    }

    public void ausgangSchrankeOeffnen(Ticket ticket) {
        if (ticket.istBezahlt()) {
            ausgangsschranke.oeffnen();
        } else {
            System.out.println("Ticket ist nicht bezahlt. Schranke bleibt geschlossen.");
        }
    }
}