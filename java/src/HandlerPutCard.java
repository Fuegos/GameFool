public class HandlerPutCard extends HandlerSet {


    public HandlerPutCard(HandlerSet handlerSet) {
        super(handlerSet);
    }


    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (match.getCache().size() == 0 && activePlayer.getActiveCard() == null &&
                activePlayer.getRunningCard() != null) {
            enemyPlayer.setActiveCard(activePlayer.getRunningCard());
            match.putCache(activePlayer.getRunningCard());
            activePlayer.setRunningCard(null);
            match.setLogs("Игрок " + activePlayer.getName() + " сделал ход!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
