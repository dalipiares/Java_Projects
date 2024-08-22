public class Ticket {
    boolean bezahlt;

    public Ticket() {
        this.bezahlt = false;
    }

    public void bezahlen() {
        this.bezahlt = true;
    }

    public boolean istBezahlt() {
        return bezahlt;
    }
}