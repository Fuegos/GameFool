public class Pack {
    private static Pack instanse;
    private Card[] card;
    private String logs;

    private Pack(Card[] card) {
        this.card = card;
    }

    public static Pack getInstanse(Card[] card) {
        if (instanse == null) {
            instanse = new Pack(card);
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
}
