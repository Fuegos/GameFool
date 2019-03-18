import java.util.ArrayList;

public class Player {
    private ArrayList<PlayingCard> fun = new ArrayList<PlayingCard>();
    private String name;
    private PlayingCard activeCard;
    private int countWins = 0;
    private boolean wontToBeat = true;
    private PlayingCard runningCard;

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

    public void setRunningCard(PlayingCard runningCard) {
        this.runningCard = runningCard;
    }

    public PlayingCard getRunningCard() {
        return this.runningCard;
    }

    public  void setActiveCard(PlayingCard playingCard) {
        this.activeCard = playingCard;
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
        for (int i = 0; i < this.fun.size(); i++) {
            if (fun.get(i).getStrong(activeCard.getSuit()) > activeCard.getStrong(activeCard.getSuit())) {
                return true;
            }
        }
        return false;
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

    public void addPoint() {
        this.countWins++;
    }
}
