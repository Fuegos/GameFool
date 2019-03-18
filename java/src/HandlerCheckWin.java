public class HandlerCheckWin extends HandlerSet {

    public HandlerCheckWin(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerCheckWin() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getRunningCard().getSuit() == "null" && activePlayer.getFun().size() == 0 &&
            match.getPack().getCard().size() == 0 ) {
            match.setWinPlayer(activePlayer);
            match.setLogs("Игрок " + activePlayer.getName() + " выиграл!");
        }
        else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
