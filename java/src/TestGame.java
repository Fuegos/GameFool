import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    void createCard() {
        Card card = new Card("4", "черви");
        Assertions.assertNotNull(card);
    }

    @Test
    void createPlayingCard() {
        PlayingCard playingCard = new Card("4", "черви");
        Assertions.assertNotNull(playingCard);
    }

    @Test
    void createPlayingCardWithFace() {
        PlayingCard playingCard = new Card("Дама", "черви");
        Face face = new Face(playingCard, "D");
        Assertions.assertNotNull(face);
    }

    @Test
    void namePlayingCardWithFace() {
        PlayingCard playingCard = new Card("Дама", "черви");
        Face face = new Face(playingCard, "D");
        Assertions.assertEquals(face.getPhrase(), "Дама черви (D)");
    }

    @Test
    void createPlayingCardTrump() {
        PlayingCard playingCard = new Card("Дама", "черви");
        Trump trump = new Trump(playingCard, "козырь");
        Assertions.assertNotNull(trump);
    }

    @Test
    void namePlayingCardTrump() {
        PlayingCard playingCard = new Card("7", "черви");
        Trump trump = new Trump(playingCard, "козырь");
        Assertions.assertEquals(trump.getPhrase(), "7 черви козырь");
    }

    @Test
    void namePlayingCardTrumpWithFace() {
        PlayingCard playingCard = new Card("Дама", "черви");
        Trump trump = new Trump(playingCard, "козырь");
        Face face = new Face(trump, "D");
        Assertions.assertEquals(face.getPhrase(), "Дама черви козырь (D)");
    }

    @Test
    void createPack() {
        Pack pack = Pack.getInstanse(new Card[]{new Card("4", "пик"), new Card("7", "треф")});
        Assertions.assertNotNull(pack);
    }

    @Test
    void createOnlyOnePack() {
        Pack packOne = Pack.getInstanse(new Card[]{new Card("4", "пик"), new Card("7", "треф")});
        Pack packTwo = Pack.getInstanse(new Card[]{new Card("4", "черви"), new Card("6", "бубен")});
        Assertions.assertArrayEquals(packOne.getCard(), packTwo.getCard());
    }

    @Test
    void checkLogsSingletonOne() {
        Pack pack = Pack.getInstanse(new Card[]{new Card("4", "пик"), new Card("7", "треф")});
        Assertions.assertNotNull(pack.getLogs(), "Колода собрана!");
    }

    @Test
    void checkLogsSingletonTwo() {
        Pack packOne = Pack.getInstanse(new Card[]{new Card("4", "пик"), new Card("7", "треф")});
        Pack packTwo = Pack.getInstanse(new Card[]{new Card("4", "черви"), new Card("6", "бубен")});
        Assertions.assertNotNull(packOne.getLogs(), "Колода уже существует!");
    }



    @Test
    void nameCard() {
        Card card = new Card("4", "черви");
        Assertions.assertEquals(card.getPhrase(), "4 черви");
    }


}
