import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    void createCard() {
        Card card = new Card();
        Assertions.assertNotNull(card);
    }

    @Test
    void nameCard() {
        Card card = new Card();
        Assertions.assertEquals(card.getName(), "4 черви!");
    }
}
