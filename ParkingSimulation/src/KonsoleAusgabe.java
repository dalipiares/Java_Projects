import java.util.function.Consumer;

public class KonsoleAusgabe implements AusgabeInterface {
    public static final Consumer<Void> printMenue = v -> {
        System.out.println("1. Parkhaus betreten (Ticket erstellen)");
        System.out.println("2. Freie Plätze anzeigen");
        System.out.println("3. Parkkosten berechnen");
        System.out.println("4. Ticket bezahlen");
        System.out.println("5. Parkhaus verlassen (Ausgangsschranke öffnen)");
        System.out.println("6. Beenden");
    };

    public static final Consumer<Void> printKeineFreienPlaetze = v -> System.out.println("Keine freien Plätze verfügbar.");

    public static final Consumer<Void> printTicketErstellt = v -> System.out.println("Ticket erstellt.");

    public static final Consumer<Integer> printFreiePlaetze = freiePlaetze -> System.out.println("Freie Plätze: " + freiePlaetze);

    public static final Consumer<Void> printKostenBerechnen = v -> System.out.print("Geben Sie die Parkdauer in Stunden ein: ");

    public static final Consumer<Double> printKosten = kosten -> System.out.println("Die Parkkosten betragen: " + kosten + " Franken");

    public static final Consumer<Void> printTicketBezahlt = v -> System.out.println("Ticket wurde bezahlt.");

    public static final Consumer<Void> printAusgang = v -> System.out.println("Simulation beendet.");

    public static final Consumer<Void> printUngueltigeOption = v -> System.out.println("Ungültige Option. Bitte erneut versuchen.");

    public static final Consumer<Void> printTicketNichtBezahlt = v -> System.out.println("Ticket ist nicht bezahlt. Schranke bleibt geschlossen.");

    @Override
    public void printMenue() {
        printMenue.accept(null);
    }

    @Override
    public void printKeineFreienPlaetze() {
        printKeineFreienPlaetze.accept(null);
    }

    @Override
    public void printTicketErstellt() {
        printTicketErstellt.accept(null);
    }

    @Override
    public void printFreiePlaetze(int freiePlaetze) {
        printFreiePlaetze.accept(freiePlaetze);
    }

    @Override
    public void printKostenBerechnen() {
        printKostenBerechnen.accept(null);
    }

    @Override
    public void printKosten(double kosten) {
        printKosten.accept(kosten);
    }

    @Override
    public void printTicketBezahlt() {
        printTicketBezahlt.accept(null);
    }

    @Override
    public void printAusgang() {
        printAusgang.accept(null);
    }

    @Override
    public void printUngueltigeOption() {
        printUngueltigeOption.accept(null);
    }

    @Override
    public void printTicketNichtBezahlt() {
        printTicketNichtBezahlt.accept(null);
    }
}