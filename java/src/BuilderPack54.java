import java.util.ArrayList;

public class BuilderPack54 extends BuilderPack {

    @Override
    public void buildCards() {
        ArrayList<PlayingCard> card = new ArrayList<PlayingCard>();
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