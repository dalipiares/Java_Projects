import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AusgabeInterface ausgabe = new KonsoleAusgabe();
            Parkhaus parkhaus = new Parkhaus(
                    100,
                    2.5,
                    ausgabe,
                    Eingangsschranke.oeffnen,
                    Ausgangsschranke.oeffnen,
                    Kasse.ticketBezahlen
            );

            Ticket currentTicket = null;
            while (true) {
                ausgabe.printMenue();
                System.out.print("Wähle eine Option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        currentTicket = parkhaus.ticketErstellen().get();
                        if (currentTicket == null) {
                            ausgabe.printKeineFreienPlaetze();
                        } else {
                            ausgabe.printTicketErstellt();
                        }
                        break;
                    case 2:
                        parkhaus.anzeigenFreiePlaetze().run();
                        break;
                    case 3:
                        if (currentTicket == null) {
                            ausgabe.printUngueltigeOption();
                        } else {
                            ausgabe.printKostenBerechnen();
                            int parkDauer = scanner.nextInt();
                            double kosten = parkhaus.kostenBerechnen().apply(parkDauer);
                            ausgabe.printKosten(kosten);
                        }
                        break;
                    case 4:
                        if (currentTicket == null) {
                            ausgabe.printUngueltigeOption();
                        } else {
                            parkhaus.ticketBezahlen().accept(currentTicket);
                        }
                        break;
                    case 5:
                        if (currentTicket == null) {
                            ausgabe.printUngueltigeOption();
                        } else {
                            parkhaus.ausgangSchrankeOeffnen().accept(currentTicket);
                            currentTicket = null;
                        }
                        break;
                    case 6:
                        ausgabe.printAusgang();
                        return;
                    default:
                        ausgabe.printUngueltigeOption();
                        break;
                }
            }
        }
    }
}