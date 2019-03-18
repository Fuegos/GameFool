public class SystemPutCardIntoFun implements Observer {

    @Override
    public void update(Player activePlayer, Player enemyPlayer, Pack pack) {
        activePlayer.replenishFun(pack);
        enemyPlayer.replenishFun(pack);
    }
}
