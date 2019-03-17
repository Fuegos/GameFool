public class Info {

    private static String[] suit = new String[] {"черви", "пик", "бубен", "треф"};
    private static String[] symbol36 = new String[] {"6", "7", "8", "9", "10"};
    private static String[] symbol56 = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static String[] symbolFace36 = new String[] {"валет", "дама", "король", "туз"};
    private static String[] symbolFace56 = new String[] {"валет", "дама", "король", "туз", "джокер"};
    private static String[] face36 = new String[] {"B", "D", "K", "T"};
    private static String[] face56 = new String[] {"B", "D", "K", "T", "J"};
    private static String trump = "козырь";

    public String[] getSuit() {
        return suit;
    }

    public String[] getSymbol36() {
        return symbol36;
    }

    public String[] getSymbol56() {
        return symbol56;
    }

    public String[] getSymbolFace36() {
        return symbolFace36;
    }

    public String[] getSymbolFace56() {
        return symbolFace56;
    }

    public String[] getFace36() {
        return face36;
    }

    public String[] getFace56() {
        return face56;
    }

    public String getTrump() {
        return trump;
    }
}
