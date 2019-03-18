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
            Cancel cancel = new Cancel("null");
            Adapter adapter = new Adapter(cancel);
            activePlayer.setRunningCard(adapter);
            match.setState(enemyPlayer, activePlayer);
            match.setActivePlayer(enemyPlayer);
            match.setLogs("Игрок " + enemyPlayer.getName() + " отбил карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
