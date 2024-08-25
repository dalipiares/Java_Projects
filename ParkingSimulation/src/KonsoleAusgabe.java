public class KonsoleAusgabe implements AusgabeInterface {
    @Override
    public void printMenue() {
        System.out.println("1. Parkhaus betreten (Ticket erstellen)");
        System.out.println("2. Freie Plätze anzeigen");
        System.out.println("3. Parkkosten berechnen");
        System.out.println("4. Ticket bezahlen");
        System.out.println("5. Parkhaus verlassen (Ausgangsschranke öffnen)");
        System.out.println("6. Beenden");
    }

    @Override
    public void printKeineFreienPlaetze() {
        System.out.println("Keine freien Plätze verfügbar.");
    }

    @Override
    public void printTicketErstellt() {
        System.out.println("Ticket erstellt.");
    }

    @Override
    public void printFreiePlaetze(int freiePlaetze) {
        System.out.println("Freie Plätze: " + freiePlaetze);
    }

    @Override
    public void printKostenBerechnen() {
        System.out.print("Geben Sie die Parkdauer in Stunden ein: ");
    }

    @Override
    public void printKosten(double kosten) {
        System.out.println("Die Parkkosten betragen: " + kosten + " Franken");
    }

    @Override
    public void printTicketBezahlt() {
        System.out.println("Ticket wurde bezahlt.");
    }

    @Override
    public void printAusgang() {
        System.out.println("Simulation beendet.");
    }

    @Override
    public void printUngueltigeOption() {
        System.out.println("Ungültige Option. Bitte erneut versuchen.");
    }

    @Override
    public void printTicketNichtBezahlt() {
        System.out.println("Ticket ist nicht bezahlt. Schranke bleibt geschlossen.");
    }
}