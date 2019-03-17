import java.util.ArrayList;
import java.util.Random;

public class Pack {
    private static Pack instanse;
    private ArrayList<PlayingCard> card = new ArrayList<PlayingCard>();
    private String logs;
    private String trump;
    private ArrayList<PlayingCard> copyCard = new ArrayList<PlayingCard>();

    private Pack() {

    }

    public void setCard(ArrayList<PlayingCard> card) {
        instanse.card = card;
        for (int i = 0; i < this.card.size(); i++) {
            this.copyCard.add(card.get(i));
        }
    }

    public void setTrump(String trump) {
        instanse.trump = trump;
    }

    private Pack(ArrayList<PlayingCard> card, String trump) {
        this.card = card;
        this.trump = trump;
        for (int i = 0; i < this.card.size(); i++) {
            this.copyCard.add(card.get(i));
        }
    }

    public static Pack getInstanse(ArrayList<PlayingCard> card, String trump) {
        if (instanse == null) {
            instanse = new Pack(card, trump);
            instanse.logs = "Колода собрана!";
        }
        else {
            instanse.logs = "Колода уже существует!";
        }
        return instanse;
    }

    public static Pack getInstanse() {
        if (instanse == null) {
            instanse = new Pack();
            instanse.logs = "Колода собрана!";
        }
        else {
            instanse.logs = "Колода уже существует!";
        }
        return instanse;
    }

    public ArrayList<PlayingCard> getCard() {
        return instanse.card;
    }

    public String getLogs() {
        return instanse.logs;
    }

    public String getTrump() {
        return instanse.trump;
    }

    public PlayingCard extractCard() {
        //todo доработать обработку пустой колоды, запись в логи)
        if (card != null) {
            Random random = new Random();
            PlayingCard card = instanse.card.get(random.nextInt(instanse.card.size()));
            instanse.card.remove(card);
            return card;
        }
        return null;
    }

    public void resetGard() {
        instanse.card.clear();
        for (int i = 0; i < instanse.copyCard.size(); i++) {
            instanse.card.add(copyCard.get(i));
        }
    }

    public void allExtractCard() {
        instanse.card.clear();
    }

    public static void deletePack() {
        instanse = null;
    }
}
