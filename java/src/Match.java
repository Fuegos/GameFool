import java.util.ArrayList;

public class Match extends Subject{
    private Pack pack;
    private ArrayList<PlayingCard> cache = new ArrayList<PlayingCard>();
    private Player winPlayer;
    private String logs;
    private String active;

    public void createPack(String type) {
        if (type.compareTo("36") == 0) {
            Pack.deletePack();
            Director director = new Director();
            BuilderPack builderPack36 = new BuilderPack36();

            director.setBuilderPack(builderPack36);
            director.collectPack();

            this.pack = director.getBuilderPack();
        }
        else if (type.compareTo("54") == 0) {
            Pack.deletePack();
            Director director = new Director();
            BuilderPack builderPack56 = new BuilderPack56();

            director.setBuilderPack(builderPack56);
            director.collectPack();

            this.pack = director.getBuilderPack();
        }
    }

    public Pack getPack() {
        return this.pack;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public String getLogs() {
        return this.logs;
    }

    public void clearPack() {
        this.pack.allExtractCard();
    }

    public ArrayList<PlayingCard> getCache() {
        return this.cache;
    }

    public void putCache(PlayingCard playingCard) {
        this.cache.add(playingCard);
    }

    public void clearCache() {
        this.cache.clear();
    }

    public boolean checkCache(PlayingCard playingCard) {
        for (int j = 0; j < this.cache.size(); j++) {
            if (playingCard.getSuit().compareTo(cache.get(j).getSuit()) == 0) {
                return true;
            }
        }
        return false;
    }


    public void setWinPlayer(Player player) {
        this.winPlayer = player;
    }

    public boolean checkCacheFun(ArrayList<PlayingCard> fun) {
        for (int i = 0; i < fun.size(); i++) {
            for (int j = 0; j < this.cache.size(); j++) {
                if (fun.get(i).getSuit().compareTo(cache.get(j).getSuit()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void natify(Player activePlayer, Player enemyPlayer) {
        observer.update(activePlayer, enemyPlayer, this.pack);

    }

    public void setState(Player activePlayer, Player enemyPlayer) {
        this.active = activePlayer.getName();
        natify(activePlayer, enemyPlayer);
    }

    public String getActive() {
        return this.active;
    }
}
