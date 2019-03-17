public class HandlerPutCard extends HandlerSet {


    public HandlerPutCard(HandlerSet handlerSet) {
        super(handlerSet);
    }


    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (match.getCache().size() == 0 && activePlayer.getActiveCard() == null) {
            //todo положить противнику карту, добавить масть в кэш
            match.setLogs("Игрок " + activePlayer.getName() + " сделал ход!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
