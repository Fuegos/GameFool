public class Card implements PlayingCard {
    private String symbol;
    private String suit;

    public Card(String symbol, String suit) {
        this.symbol = symbol;
        this.suit = suit;
    }

    public String getPhrase() {
        return this.symbol + " " + suit;
    }

    public String getSuit() {
        return this.suit;
    }

    @Override
    public int getStrong(String suit) {
        int strong = 0;
        Info info = new Info();
        if (this.suit == suit) {
            strong += info.getStrongSymbol(this.symbol);
        }
        return strong;
    }
}
