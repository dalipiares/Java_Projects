public class Kasse {
    public void ticketBezahlen(Ticket ticket) {
        ticket.bezahlen();
        System.out.println("Ticket wurde bezahlt.");
    }
}