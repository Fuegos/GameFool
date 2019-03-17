public class HandlerRepelCard extends HandlerSet {

    public HandlerRepelCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerRepelCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() != null && activePlayer.checkRepel()) {
            //todo отбить карту
            match.setLogs("Игрок " + activePlayer.getName() + " отбил карту!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
