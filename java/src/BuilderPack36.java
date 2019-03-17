import java.util.ArrayList;

public class BuilderPack36 extends BuilderPack {

    @Override
    public void buildCards() {
        ArrayList<Card> card = new ArrayList<Card>();
        //todo добавить возможность добавлять карты
        result.setCard(card);
    }

    @Override
    public void buildTrump() {
        //todo добавить случайный характер выбора козыря.
        String trump = "черви";
        result.setTrump(trump);

    }
}
