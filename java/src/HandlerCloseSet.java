public class HandlerCloseSet extends HandlerSet {

    public HandlerCloseSet(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerCloseSet() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() == null && match.checkCache(activePlayer.getFun()) == false) {
            //todo передать инициативу сопернику, обнулить активные карты

            match.setLogs("Игрок " + enemyPlayer.getName() + " отбил карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
