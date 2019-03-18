public class HandlerCloseSet extends HandlerSet {

    public HandlerCloseSet(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerCloseSet() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() == null && match.checkCache(activePlayer.getRunningCard()) == false &&
            enemyPlayer.getActiveCard() == null) {
            //todo передать инициативу сопернику, обнулить активные карты
            activePlayer.activeOff();
            enemyPlayer.activeOn();
            match.setLogs("Игрок " + enemyPlayer.getName() + " отбил карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
