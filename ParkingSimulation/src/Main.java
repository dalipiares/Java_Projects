import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parkhaus parkhaus = new Parkhaus(100, 2.5);
        Ticket currentTicket = null;

        while (true) {
            System.out.println("\n--- Parkhaus Simulation ---");
            System.out.println("1. Parkhaus betreten (Ticket erstellen)");
            System.out.println("2. Freie Plätze anzeigen");
            System.out.println("3. Parkkosten berechnen");
            System.out.println("4. Ticket bezahlen");
            System.out.println("5. Parkhaus verlassen (Ausgangsschranke öffnen)");
            System.out.println("6. Beenden");
            System.out.println("Wähle eine Option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                currentTicket = parkhaus.ticketErstellen();
            } else if (choice == 2) {
                parkhaus.anzeigenFreiePlaetze();
            } else if (choice == 3) {
                if (currentTicket == null) {
                    System.out.println("Bitte erst ein Ticket erstellen.");
                } else {
                    System.out.print("Geben Sie die Parkdauer in Stunden ein: ");
                    int parkDauer = scanner.nextInt();
                    double kosten = parkhaus.kostenBerechnen(parkDauer);
                    System.out.println("Die Parkkosten betragen: " + kosten + " Franken");
                }
            } else if (choice == 4) {
                if (currentTicket == null) {
                    System.out.println("Kein Ticket vorhanden. Bitte erst ein Ticket erstellen.");
                } else {
                    parkhaus.ticketBezahlen(currentTicket);
                }
            } else if (choice == 5) {
                if (currentTicket == null) {
                    System.out.println("Kein Ticket vorhanden. Bitte erst ein Ticket erstellen.");
                } else {
                    parkhaus.ausgangSchrankeOeffnen(currentTicket);
                }
            } else if (choice == 6) {
                System.out.println("Simulation beendet.");
                scanner.close();
                break;
            } else {
                System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }
        }
    }
}