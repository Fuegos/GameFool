public interface PlayingCard {

    String getPhrase();

    String getSuit();

    String getSymbol();

    int getStrong(String suit);
}
