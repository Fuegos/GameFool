import java.util.ArrayList;

public class Player {
    private ArrayList<PlayingCard> fun = new ArrayList<PlayingCard>();
    private String name;
    private PlayingCard activeCard;
    private int countWins = 0;
    private boolean wontToBeat = true;

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

    public void putActiveCard(PlayingCard playingCard) {
        this.activeCard = playingCard;
    }

    public boolean checkRepel() {
        //todo доработать
        return true;
    }

    public void setWontToBeat() {
        this.wontToBeat = true;
    }

    public void setNotWontToBeat() {
        this.wontToBeat = false;
    }

    public boolean getWontToBeat() {
        return this.wontToBeat;
    }
}
