public class HandlerTossCard extends HandlerSet {


    public HandlerTossCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerTossCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() == null && match.checkCache(activePlayer.getRunningCard()) &&
                enemyPlayer.getActiveCard() == null) {
            enemyPlayer.setActiveCard(activePlayer.getRunningCard());
            activePlayer.setRunningCard(null);
            match.setLogs("Игрок " + activePlayer.getName() + " подкинул картишек!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
