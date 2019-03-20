public class HandlerCloseSet extends HandlerSet {

    public HandlerCloseSet(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerCloseSet() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (enemyPlayer.getRunningCard().getSuit() == "отмена") {
            match.setState(enemyPlayer, activePlayer);
            activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            enemyPlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            match.clearCache();
            match.setLogs("Игрок " + activePlayer.getName() + " отбил карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
