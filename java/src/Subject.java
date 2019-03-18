abstract class Subject {
    protected Observer observer;

    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void dettach(Observer observer) {
        if (this.observer == observer) {
            this.observer = null;
        }
    }

    public abstract void natify(Player activePlayer, Player enemyPlayer);

}
