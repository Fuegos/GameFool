abstract class DecoratorCard implements PlayingCard {

    private PlayingCard playingCard;
    private String phrase;

    public DecoratorCard(PlayingCard playingCard, String phrase) {
        this.playingCard = playingCard;
        this.phrase = phrase;
    }


}
