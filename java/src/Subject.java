import java.util.ArrayList;

abstract class Subject {
    protected ArrayList<Observer> observer = new ArrayList<Observer>();

    public void attach(Observer observer) {
        this.observer.add(observer);
    }

    public void dettach(Observer observer) {
        this.observer.remove(observer);
    }

    public abstract void natify(Player activePlayer, Player enemyPlayer);

}
