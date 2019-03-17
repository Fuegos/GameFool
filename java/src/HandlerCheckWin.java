public class HandlerCheckWin extends HandlerSet {

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() == null && activePlayer.getFun().size() == 0 &&
            match.getPack().getCard().size() == 0) {
            match.setLogs("Игрок " + activePlayer.getName() + " выиграл!");
        }
        else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
