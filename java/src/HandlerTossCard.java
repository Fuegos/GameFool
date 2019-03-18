public class HandlerTossCard extends HandlerSet {


    public HandlerTossCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerTossCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard().getSuit() == "null" && match.checkCache(activePlayer.getRunningCard()) &&
                enemyPlayer.getActiveCard().getSuit() == "null" && activePlayer.getRunningCard().getSuit() != "отмена") {
            enemyPlayer.setActiveCard(activePlayer.getRunningCard());
            match.putCache(activePlayer.getActiveCard());
            activePlayer.setRunningCard(null);
            match.setLogs("Игрок " + activePlayer.getName() + " подкинул картишек!");
        } else {
            if (activePlayer.getRunningCard().getSuit() == "null" && activePlayer.getRunningCard().getSuit() != "отмена") {
                match.setLogs("Игрок " + activePlayer.getName() + " выбрал неверную карту!");
                activePlayer.setRunningCard(null);
            }
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
