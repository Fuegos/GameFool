import java.util.ArrayList;

public class Player {
    private ArrayList<PlayingCard> fun = new ArrayList<PlayingCard>();
    private String name;
    private PlayingCard activeCard;
    private int countWins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void createFun(Pack pack) {
        for(int i = 0; i < 6; i++) {
            fun.add(pack.extractCard());
        }
    }

    public PlayingCard getActiveCard() {
        return this.activeCard;
    }

    public ArrayList<PlayingCard> getFun() {
        return fun;
    }

    public void putFun(PlayingCard playingCard) {
        this.fun.add(playingCard);
    }

}
