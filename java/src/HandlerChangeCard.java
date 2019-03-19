public class HandlerChangeCard extends HandlerSet {

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getRunningCard().getSuit() == "null") {
            match.setWaitInputTrue();
            match.setLogs("Игрок " + activePlayer.getName() + " выбирает карту!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
