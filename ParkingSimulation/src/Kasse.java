import java.util.function.Consumer;

public class Kasse {
    public static final Consumer<Ticket> ticketBezahlen = Ticket::bezahlen;
}