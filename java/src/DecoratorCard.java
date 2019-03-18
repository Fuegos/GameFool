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

    @Override
    public int getStrong(String suit) {
        return playingCard.getStrong(suit);
    }


}
