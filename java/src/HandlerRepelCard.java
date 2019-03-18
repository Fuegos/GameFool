public class HandlerRepelCard extends HandlerSet {

    public HandlerRepelCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerRepelCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() != null && activePlayer.checkRepel() && activePlayer.getRunningCard() != null) {
            if (activePlayer.getRunningCard().getStrong(activePlayer.getActiveCard().getSuit()) >
                    activePlayer.getActiveCard().getStrong(activePlayer.getActiveCard().getSuit())) {
                match.putCache(activePlayer.getActiveCard());
                activePlayer.setActiveCard(null);
                activePlayer.setRunningCard(null);
                match.setLogs("Игрок " + activePlayer.getName() + " отбил карту!");
            }
            else {
                match.setLogs("Игрок " + activePlayer.getName() + " выбрал неверную карту!");
                activePlayer.setRunningCard(null);
            }

        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
