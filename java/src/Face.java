public class Face extends DecoratorCard {
    private String nomen;

    //todo доработать
    public Face(PlayingCard playingCard, String nomen) {
        super(playingCard);
        this.nomen = nomen;
    }

    public String getPhrase() {
        return super.getPhrase() + " (" + nomen + ")";
    }
}
