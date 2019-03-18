public class HandlerCloseSet extends HandlerSet {

    public HandlerCloseSet(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerCloseSet() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard().getSuit() == "null" && match.checkCache(activePlayer.getRunningCard()) == false &&
                enemyPlayer.getActiveCard().getSuit() == "null" && match.checkCacheFun(activePlayer.getFun()) == false ||
                activePlayer.getRunningCard().getSuit() == "отмена") {
            activePlayer.activeOff();
            activePlayer.setRunningCard(null);
            enemyPlayer.activeOn();
            match.setLogs("Игрок " + enemyPlayer.getName() + " отбил карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
