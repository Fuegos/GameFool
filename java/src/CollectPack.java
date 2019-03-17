import java.util.ArrayList;

public class CollectPack {
    private ArrayList<Card> card;

    public CollectPack() {
        //todo доработать к строителю
        card = new ArrayList<Card>();

    }

    public ArrayList<Card> getCard() {
        return this.card;
    }
}
