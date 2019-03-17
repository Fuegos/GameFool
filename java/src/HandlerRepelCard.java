public class HandlerRepelCard extends HandlerSet {

    public HandlerRepelCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerRepelCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() != null && activePlayer.checkRepel() && activePlayer.getWontToBeat()) {
            //todo отбить карту или опросить о желании не бить
            match.setLogs("Игрок " + activePlayer.getName() + " отбил карту!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
