public class Trump extends DecoratorCard{

    private String nomen;

    public Trump(PlayingCard playingCard, String nomen) {
        super(playingCard);
        this.nomen = nomen;
    }

    public String getPhrase() {
        return super.getPhrase() + " " + nomen;
    }

    @Override
    public int getStrong(String suit) {
        return super.getStrong(suit) + 100;
    }
}
