import org.junit.jupiter.api.Test;

public class EingangsschrankeTest {
    @Test
    public void oeffnenDoesNotThrowException() {
        Eingangsschranke eingangsschranke = new Eingangsschranke();
        eingangsschranke.oeffnen();
    }
}