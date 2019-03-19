public class HandlerTossCard extends HandlerSet {


    public HandlerTossCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerTossCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (match.getCache().size() != 0 && activePlayer.getRunningCard().getSuit() == "null" &&
                enemyPlayer.getRunningCard().getSuit() == "null") {

            if (match.checkCache(activePlayer.getActiveCard()) == false) {
                match.setLogs("Игрок " + activePlayer.getName() + " выбрал недостойную карту!");
                activePlayer.putFun(activePlayer.getActiveCard());
                activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
            }
            else if(activePlayer.getActiveCard().getSuit() == "отмена") {
                activePlayer.setRunningCard(activePlayer.getActiveCard());
                match.setActivePlayer(enemyPlayer);
                match.setState(enemyPlayer, activePlayer);
                activePlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
                enemyPlayer.setRunningCard(new FactoryCardExotic().createCard("null"));
                match.clearCache();
                match.setLogs("Игроку " + activePlayer.getName() + " нечего подкидывать!");
            }
            else {
                activePlayer.setRunningCard(activePlayer.getActiveCard());
                match.setActivePlayer(enemyPlayer);
                match.setLogs("Игрок " + activePlayer.getName() + " подкинул картишек!");
            }

        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
