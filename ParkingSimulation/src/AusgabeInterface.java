public interface AusgabeInterface {
    void printMenue();
    void printKeineFreienPlaetze();
    void printTicketErstellt();
    void printFreiePlaetze(int freiePlaetze);
    void printKostenBerechnen();
    void printKosten(double kosten);
    void printTicketBezahlt();
    void printAusgang();
    void printUngueltigeOption();
    void printTicketNichtBezahlt();
}