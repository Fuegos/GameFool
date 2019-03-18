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
    void nameCard() {
        Card card = new Card("4", "черви");
        Assertions.assertEquals(card.getPhrase(), "4 черви");
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
        ArrayList<PlayingCard> cards  = new ArrayList<PlayingCard>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertNotNull(pack);
    }

    @Test
    void createOnlyOnePack() {
        Pack.deletePack();
        ArrayList<PlayingCard> cardsOne  = new ArrayList<PlayingCard>();
        ArrayList<PlayingCard> cardsTwo  = new ArrayList<PlayingCard>();
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
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertNotNull(pack.getLogs(), "Колода собрана!");
    }

    @Test
    void checkLogsSingletonTwo() {
        Pack.deletePack();
        ArrayList<PlayingCard> cardsOne  = new ArrayList<PlayingCard>();
        ArrayList<PlayingCard> cardsTwo  = new ArrayList<PlayingCard>();
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
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        Assertions.assertEquals(pack.getTrump(), "черви");
    }

    @Test
    void extractCardOfPack() {
        Pack.deletePack();
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "черви");
        int sizeBefor = pack.getCard().size();
        PlayingCard card = pack.extractCard();
        System.out.println(card.getPhrase());
        int sizeAfter = pack.getCard().size();
        pack.resetGard();
        Assertions.assertTrue((sizeBefor - sizeAfter) == 1);
    }

    @Test
    void resetPack() {
        Pack.deletePack();
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        cards.add(new Card("4", "пик"));
        cards.add(new Card("7", "треф"));
        Pack pack = Pack.getInstanse(cards, "крести");
        int sizeBefor = pack.getCard().size();
        PlayingCard card = pack.extractCard();
        pack.resetGard();
        int sizeAfter = pack.getCard().size();
        Assertions.assertEquals(sizeAfter, 2);
    }

    @Test
    void collectPack36() {
        Pack.deletePack();
        BuilderPack collect = new BuilderPack56();
        Assertions.assertNotNull(collect);
    }

    @Test
    void collectPack56() {
        Pack.deletePack();
        BuilderPack collect = new BuilderPack56();
        Assertions.assertNotNull(collect);
    }

    @Test
    void buildPack36() {
        Pack.deletePack();
        Director director = new Director();
        BuilderPack builderPack36 = new BuilderPack36();

        director.setBuilderPack(builderPack36);
        director.collectPack();

        Pack pack = director.getBuilderPack();

        Assertions.assertNotNull(pack);
    }

    @Test
    void fullPack36() {
        Pack.deletePack();
        Director director = new Director();
        BuilderPack builderPack36 = new BuilderPack36();

        director.setBuilderPack(builderPack36);
        director.collectPack();

        Pack pack = director.getBuilderPack();

        ArrayList<PlayingCard> card = pack.getCard();
        for(int i = 0; i < pack.getCard().size(); i++) {
            System.out.println(card.get(i).getPhrase());
        }
        Assertions.assertTrue(pack.getCard().size() == 36);
    }

    @Test
    void buildPack56() {
        Pack.deletePack();
        Director director = new Director();
        BuilderPack builderPack56 = new BuilderPack56();

        director.setBuilderPack(builderPack56);
        director.collectPack();

        Pack pack = director.getBuilderPack();

        Assertions.assertNotNull(pack);
    }

    @Test
    void fullPack56() {
        Pack.deletePack();
        Director director = new Director();
        BuilderPack builderPack56 = new BuilderPack56();

        director.setBuilderPack(builderPack56);
        director.collectPack();

        Pack pack = director.getBuilderPack();

        ArrayList<PlayingCard> card = pack.getCard();
        for(int i = 0; i < pack.getCard().size(); i++) {
            System.out.println(card.get(i).getPhrase());
        }
        Assertions.assertEquals(pack.getCard().size(), 56, "Число карт = " + pack.getCard().size());
    }

    @Test
    void createCoR() {
        Match match = new Match();
        HandlerSet handlerCheckWin = new HandlerCheckWin();
        HandlerSet handlerPutCard = new HandlerPutCard(handlerCheckWin);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerPutCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerTossCard);
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerCloseSet);
        HandlerSet handlerPickUpCard = new HandlerPickUpCard(handlerRepelCard);
        Assertions.assertNotNull(handlerPutCard);
    }

    @Test
    void playSetEmptyFanAndEmptyPack() {
        HandlerSet handlerCheckWin = new HandlerCheckWin();
        Match match = new Match();
        match.createPack("36");
        match.clearPack();
        Player playerOne = new Player("Я");
        Player playerTwo = new Player("Он");
        handlerCheckWin.work(match, playerOne, playerTwo);

        Assertions.assertEquals(match.getLogs(), "Игрок Я выиграл!" );
    }

    @Test
    void playSetPutCard() {
        HandlerSet handlerCheckWin = new HandlerCheckWin();
        HandlerSet handlerPutCard = new HandlerPutCard(handlerCheckWin);
        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        playerOne.setRunningCard(new Card("7","черви"));
        handlerPutCard.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Я сделал ход!" );
    }

    @Test
    void playSetTossCard() {
        HandlerSet handlerTossCard = new HandlerTossCard();
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        match.putCache(new Card("7","черви"));
        playerOne.putFun(new Card("7", "черви"));
        playerOne.setRunningCard(new Card("8","черви"));
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Я подкинул картишек!");
    }

    @Test
    void playSetClose() {
        HandlerSet handlerCloseSet = new HandlerCloseSet();
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        match.putCache(new Card("7","грязи"));
        Observer systemPutCardIntoFun = new SystemPutCardIntoFun();
        match.attach(systemPutCardIntoFun);
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Он отбил карты!");
    }

    @Test
    void playSetRepelCard() {
        HandlerSet handlerRepelCard = new HandlerRepelCard();
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        playerOne.putActiveCard(new Card("7", "пик"));
        playerOne.setRunningCard(new Card("8", "пик"));
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Я отбил карту!");
    }

    @Test
    void playSetPickUpCard() {
        HandlerSet handlerPickUpCard = new HandlerPickUpCard();
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerPickUpCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        playerOne.putActiveCard(new Trump(new Face(new Card("туз", "пик"), "T"), "козырь"));
        match.getPack().setTrump("пик");
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Я взял все карты!");
    }

    @Test
    void playSetChangeCard() {
        HandlerSet handlerChangeCard = new HandlerChangeCard();
        HandlerSet handlerPickUpCard = new HandlerPickUpCard(handlerChangeCard);
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerPickUpCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        match.putCache((new Card("6", "пик")));
        playerOne.putFun((new Card("7", "пик")));
        match.getPack().setTrump("пик");
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getLogs(), "Игрок Я выбрал карту!");
    }

    @Test
    void adapterCardCancel() {
        Cancel cancel = new Cancel("отмена");
        Adapter adapter = new Adapter(cancel);
        Assertions.assertEquals(adapter.getPhrase(), "отмена");
    }

    @Test
    void createObserver() {
        HandlerSet handlerChangeCard = new HandlerChangeCard();
        HandlerSet handlerPickUpCard = new HandlerPickUpCard(handlerChangeCard);
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerPickUpCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");
        Player playerOne = new Player("Я");
        playerOne.createFun(match.getPack());
        Player playerTwo = new Player("Он");
        playerTwo.createFun(match.getPack());
        match.putCache(new Card("7","грязи"));

        Observer systemPutCardIntoFun = new SystemPutCardIntoFun();
        match.attach(systemPutCardIntoFun);
        handlerCheckWin.work(match, playerOne, playerTwo);
        Assertions.assertEquals(match.getActive(), "Он");
    }

    @Test
    void playMatch() {
        HandlerSet handlerChangeCard = new HandlerChangeCard();
        HandlerSet handlerPickUpCard = new HandlerPickUpCard(handlerChangeCard);
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerPickUpCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

    }



}
