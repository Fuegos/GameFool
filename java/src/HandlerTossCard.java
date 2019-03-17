public class HandlerTossCard extends HandlerSet {


    public HandlerTossCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerTossCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() == null) {
            //todo подкинуть противнику карту, сравнить с кэшом
            match.setLogs("Игрок " + activePlayer.getName() + " подкинул картишек!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
