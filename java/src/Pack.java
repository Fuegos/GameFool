public class Pack {
    private static Pack instanse;
    private Card[] card;
    private String logs;
    private String trump;

    private Pack(Card[] card, String trump) {
        this.card = card;
        this.trump = trump;
    }

    public static Pack getInstanse(Card[] card, String trump) {
        if (instanse == null) {
            instanse = new Pack(card, trump);
            instanse.logs = "Колода собрана!";
        }
        else {
            instanse.logs = "Колода уже существует!";
        }
        return instanse;
    }

    public Card[] getCard() {
        return instanse.card;
    }

    public String getLogs() {
        return instanse.logs;
    }

    public String getTrump() {
        return instanse.trump;
    }
}
