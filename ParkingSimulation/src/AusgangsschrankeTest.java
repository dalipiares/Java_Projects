import org.junit.jupiter.api.Test;

public class AusgangsschrankeTest {
    @Test
    public void oeffnenDoesNotThrowException() {
        Ausgangsschranke ausgangsschranke = new Ausgangsschranke();
        ausgangsschranke.oeffnen();
    }
}