import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    void createCard() {
        Card card = new Card();
        Assertions.assertNotNull(card);
    }
}
