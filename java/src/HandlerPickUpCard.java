public class HandlerPickUpCard extends HandlerSet {


    public HandlerPickUpCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerPickUpCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (enemyPlayer.getRunningCard().getSuit() != "null" && activePlayer.checkRepel(enemyPlayer.getRunningCard()) ||
            activePlayer.getActiveCard().getSuit() == "отмена") {
            for (int i = 0; i < match.getCache().size(); i++) {
                activePlayer.putFun(match.getCache().get(i));
            }
            activePlayer.putFun(enemyPlayer.getRunningCard());
            activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            enemyPlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            match.clearCache();
            match.setActivePlayer(enemyPlayer);
            match.setState(enemyPlayer, activePlayer);
            match.setLogs("Игрок " + activePlayer.getName() + " взял все карты!");
        }
        else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
