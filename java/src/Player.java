import java.util.ArrayList;

public class Player {
    private ArrayList<PlayingCard> fun = new ArrayList<PlayingCard>();
    private String name;
    private PlayingCard activeCard;
    private int countWins = 0;
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
        if (this.runningCard == null) {
            Cancel cancel = new Cancel("null");
            Adapter adapter = new Adapter(cancel);
            return adapter;
        }
        return this.runningCard;
    }

    public  void setActiveCard(PlayingCard playingCard) {
        this.activeCard = playingCard;
    }

    public PlayingCard getActiveCard() {
        if (this.activeCard == null) {
            Cancel cancel = new Cancel("null");
            Adapter adapter = new Adapter(cancel);
            return adapter;
        }
        return this.activeCard;
    }

    public ArrayList<PlayingCard> getFun() {
        return fun;
    }

    public void putFun(PlayingCard playingCard) {
        this.fun.add(playingCard);
    }

    public PlayingCard extractFun(int number) {
        PlayingCard playingCard = this.fun.get(number - 1);
        this.fun.remove(playingCard);
        return playingCard;
    }

    public void putActiveCard(PlayingCard playingCard) {
        this.activeCard = playingCard;
    }

    public boolean checkRepel() {
        for (int i = 0; i < this.fun.size(); i++) {
            if (fun.get(i).getStrong(activeCard.getSuit()) > activeCard.getStrong(activeCard.getSuit())) {
                return true;
            }
        }
        return false;
    }


    public void addPoint() {
        this.countWins++;
    }


    public void replenishFun(Pack pack) {
        while (this.fun.size() != 6 && pack.getCard().size() != 0) {
            this.fun.add(pack.extractCard());
        }
    }

    public String printFun() {
        String str = "***Веер игрока " + this.name + ": ";
        for(int i = 0; i < this.fun.size(); i++) {
            str += fun.get(i).getPhrase() + " | ";
        }
        return str;
    }

}
