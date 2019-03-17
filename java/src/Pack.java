import java.util.ArrayList;

public class Pack {
    private static Pack instanse;
    private ArrayList<Card> card;
    private String logs;
    private String trump;
    private ArrayList<Card> copyCard;

    private Pack(ArrayList<Card> card, String trump) {
        this.card = card;
        this.trump = trump;
        this.copyCard = new ArrayList<Card>();
        for (int i = 0; i < this.card.size(); i++) {
            this.copyCard.add(card.get(i));
        }
    }

    public static Pack getInstanse(ArrayList<Card> card, String trump) {
        if (instanse == null) {
            instanse = new Pack(card, trump);
            instanse.logs = "Колода собрана!";
        }
        else {
            instanse.logs = "Колода уже существует!";
        }
        return instanse;
    }

    public ArrayList<Card> getCard() {
        return instanse.card;
    }

    public String getLogs() {
        return instanse.logs;
    }

    public String getTrump() {
        return instanse.trump;
    }

    public Card extractCard() {
        //todo доработать метод извлечения карты из колоды, обработка пустой колоды, запись в логи)
        if (card != null) {
            Card card = instanse.card.get(0);
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
}
