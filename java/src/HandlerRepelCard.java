public class HandlerRepelCard extends HandlerSet {

    public HandlerRepelCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerRepelCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (enemyPlayer.getRunningCard().getSuit() != "null" &&
                activePlayer.getActiveCard().getSuit() != "отмена") {
            if (activePlayer.getActiveCard().getStrong(enemyPlayer.getRunningCard().getSuit()) >
                    enemyPlayer.getRunningCard().getStrong(enemyPlayer.getRunningCard().getSuit())) {
                match.putCache(activePlayer.getRunningCard());
                match.putCache(enemyPlayer.getRunningCard());
                activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
                enemyPlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
                match.setActivePlayer(enemyPlayer);
                match.setLogs("Игрок " + activePlayer.getName() + " отбил карту!");
            }
            else {
                match.setLogs("Игрок " + activePlayer.getName() + " выбрал неверную карту!");
                activePlayer.putFun(activePlayer.getActiveCard());
                activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            }
        }
        else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
