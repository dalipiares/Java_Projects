import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Parkhaus parkhaus = new Parkhaus(100, 2.5, new KonsoleAusgabe());
            Ticket currentTicket = null;
            while (true) {
                parkhaus.getAusgabe().printMenue();
                System.out.print("Wähle eine Option: ");


                int choice = scanner.nextInt();

                if (choice == 1) {
                    currentTicket = parkhaus.ticketErstellen();
                    if (currentTicket == null) {
                        parkhaus.getAusgabe().printKeineFreienPlaetze();
                    } else {
                        parkhaus.getAusgabe().printTicketErstellt();
                    }
                } else if (choice == 2) {
                    parkhaus.anzeigenFreiePlaetze();
                } else if (choice == 3) {
                    if (currentTicket == null) {
                        parkhaus.getAusgabe().printUngueltigeOption();
                    } else {
                        parkhaus.getAusgabe().printKostenBerechnen();
                        int parkDauer = scanner.nextInt();
                        double kosten = parkhaus.kostenBerechnen(parkDauer);
                        parkhaus.getAusgabe().printKosten(kosten);
                    }
                } else if (choice == 4) {
                    if (currentTicket == null) {
                        parkhaus.getAusgabe().printUngueltigeOption();
                    } else {
                        parkhaus.ticketBezahlen(currentTicket);
                    }
                } else if (choice == 5) {
                    if (currentTicket == null) {
                        parkhaus.getAusgabe().printUngueltigeOption();
                    } else {
                        parkhaus.ausgangSchrankeOeffnen(currentTicket);
                        currentTicket = null;
                    }
                } else if (choice == 6) {
                    parkhaus.getAusgabe().printAusgang();
                    break;
                } else {
                    parkhaus.getAusgabe().printUngueltigeOption();
                }
            }
        }
    }
}