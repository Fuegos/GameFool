public class HandlerPutCard extends HandlerSet {


    public HandlerPutCard(HandlerSet handlerSet) {
        super(handlerSet);
    }


    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (match.getCache().size() == 0 && activePlayer.getRunningCard().getSuit() == "null" &&
                enemyPlayer.getRunningCard().getSuit() == "null") {
            if(activePlayer.getActiveCard().getSuit() == "отмена") {
                activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
                match.setLogs("Игроку " + activePlayer.getName() + " необходимо выбрать карту!");
            }
            else {
                activePlayer.setRunningCard(activePlayer.getActiveCard());
                match.setActivePlayer(enemyPlayer);
                match.setLogs("Игрок " + activePlayer.getName() + " сделал ход!");
            }
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
