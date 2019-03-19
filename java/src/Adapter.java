public class Adapter implements PlayingCard {
    private Cancel cancel;

    public Adapter(Cancel cancel) {
        this.cancel = cancel;
    }

    @Override
    public String getPhrase() {
        return this.cancel.getStatus();
    }

    @Override
    public String getSuit() {
        return this.cancel.getStatus();
    }

    @Override
    public String getSymbol() {
        return "not";
    }


    @Override
    public int getStrong(String suit) {
        return 0;
    }
}
