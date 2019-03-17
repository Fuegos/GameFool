abstract class DecoratorCard implements PlayingCard {

    private PlayingCard playingCard;

    public DecoratorCard(PlayingCard playingCard) {
        this.playingCard = playingCard;
    }

    public String getPhrase() {
        return playingCard.getPhrase();
    }

    public String getSuit() {
        return playingCard.getSuit();
    }


}
