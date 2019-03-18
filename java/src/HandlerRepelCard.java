public class HandlerRepelCard extends HandlerSet {

    public HandlerRepelCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerRepelCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard().getSuit() != "null" && activePlayer.checkRepel() &&
                activePlayer.getRunningCard().getSuit() != "null" && activePlayer.getRunningCard().getSuit() != "отмена") {
            if (activePlayer.getRunningCard().getStrong(activePlayer.getActiveCard().getSuit()) >
                    activePlayer.getActiveCard().getStrong(activePlayer.getActiveCard().getSuit())) {
                match.putCache(activePlayer.getRunningCard());
                Cancel cancel = new Cancel("null");
                Adapter adapter = new Adapter(cancel);
                activePlayer.setActiveCard(adapter);
                activePlayer.setRunningCard(adapter);
                match.setActivePlayer(enemyPlayer);
                match.setLogs("Игрок " + activePlayer.getName() + " отбил карту!");
            }
            else {
                match.setLogs("Игрок " + activePlayer.getName() + " выбрал неверную карту!");
                Cancel cancel = new Cancel("null");
                Adapter adapter = new Adapter(cancel);
                activePlayer.setRunningCard(adapter);
            }

        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
