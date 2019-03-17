import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Pack.deletePack();
        ArrayList<Card> cards  = new ArrayList<Card>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertNotNull(pack);
    }

    @Test
    void createOnlyOnePack() {
        Pack.deletePack();
        ArrayList<Card> cardsOne  = new ArrayList<Card>();
        ArrayList<Card> cardsTwo  = new ArrayList<Card>();
        cardsOne.add(new Card("4", "пик"));
        cardsOne.add(new Card("7", "треф"));
        cardsTwo.add(new Card("4", "черви"));
        cardsTwo.add(new Card("6", "бубен"));
        Pack packOne = Pack.getInstanse(cardsOne, "черви");
        Pack packTwo = Pack.getInstanse(cardsTwo, "черви");
        Assertions.assertArrayEquals(packOne.getCard().toArray(), packTwo.getCard().toArray());
    }

    @Test
    void checkLogsSingletonOne() {
        Pack.deletePack();
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertNotNull(pack.getLogs(), "Колода собрана!");
    }

    @Test
    void checkLogsSingletonTwo() {
        Pack.deletePack();
        ArrayList<Card> cardsOne  = new ArrayList<Card>();
        ArrayList<Card> cardsTwo  = new ArrayList<Card>();
        cardsOne.add(new Card("4", "пик"));
        cardsOne.add(new Card("7", "треф"));
        cardsTwo.add(new Card("4", "черви"));
        cardsTwo.add(new Card("6", "бубен"));
        Pack packOne = Pack.getInstanse(cardsOne, "черви");
        Pack packTwo = Pack.getInstanse(cardsTwo, "черви");
        Assertions.assertNotNull(packOne.getLogs(), "Колода уже существует!");
    }

    @Test
    void getTrump() {
        Pack.deletePack();
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertEquals(pack.getTrump(), "черви");
    }

    @Test
    void extractCardOfPack() {
        Pack.deletePack();
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        int sizeBefor = pack.getCard().size();
        Card card = pack.extractCard();
        System.out.println(card.getPhrase());
        int sizeAfter = pack.getCard().size();
        pack.resetGard();
        Assertions.assertTrue((sizeBefor - sizeAfter) == 1);
    }

    @Test
    void resetPack() {
        Pack.deletePack();
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "крести");
        int sizeBefor = pack.getCard().size();
        Card card = pack.extractCard();
        pack.resetGard();
        int sizeAfter = pack.getCard().size();
        Assertions.assertEquals(sizeAfter, 2);
    }

    @Test
    void collectPack36() {
        Pack.deletePack();
        BuilderPack collect = new BuilderPack36();
        Assertions.assertNotNull(collect);
    }

    @Test
    void collectPack54() {
        Pack.deletePack();
        BuilderPack collect = new BuilderPack54();
        Assertions.assertNotNull(collect);
    }

    @Test
    void nameCard() {
        Card card = new Card("4", "черви");
        Assertions.assertEquals(card.getPhrase(), "4 черви");
    }


}
