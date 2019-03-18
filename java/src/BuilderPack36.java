import java.util.ArrayList;
import java.util.Random;

public class BuilderPack36 extends BuilderPack {

    @Override
    public void buildCards() {
        ArrayList<PlayingCard> card = new ArrayList<PlayingCard>();
        Info info = new Info();
        String[] suit = info.getSuit();
        String[] symbol = info.getSymbol36();
        String[] symbolFace = info.getSymbolFace36();
        String[] face = info.getFace36();
        for(int i = 0; i < suit.length; i++) {
            if (result.getTrump() != suit[i]) {
                for (int j = 0; j < symbol.length; j++) {
                    card.add(new Card(symbol[j], suit[i]));
                }
            }
            else {
                for (int j = 0; j < symbol.length; j++) {
                    card.add(new Trump(new Card(symbol[j], suit[i]), info.getTrump()));
                }
            }
        }
        for(int i = 0; i < suit.length; i++) {
            if (result.getTrump() != suit[i]) {
                for (int j = 0; j < symbolFace.length; j++) {
                    card.add(new Face(new Card(symbolFace[j], suit[i]), face[j]));
                }
            }
            else {
                for (int j = 0; j < symbolFace.length; j++) {
                    card.add(new Face(new Trump(new Card(symbolFace[j], suit[i]), info.getTrump()), face[j]));
                }
            }
        }
        result.setCard(card);
    }

    @Override
    public void buildTrump() {
        Info info = new Info();
        Random random = new Random();
        String[] suit = info.getSuit();
        result.setTrump(suit[random.nextInt(suit.length)]);
    }
}
