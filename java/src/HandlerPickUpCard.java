public class HandlerPickUpCard extends HandlerSet {


    public HandlerPickUpCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerPickUpCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard().getSuit() != "null" && activePlayer.checkRepel() == false ||
                activePlayer.getRunningCard().getSuit() == "отмена") {
            for (int i = 0; i < match.getCache().size(); i++) {
                activePlayer.putFun(match.getCache().get(i));
            }
            match.clearCache();
            Cancel cancel = new Cancel("null");
            Adapter adapter = new Adapter(cancel);
            activePlayer.setActiveCard(adapter);
            match.setActivePlayer(enemyPlayer);
            match.setLogs("Игрок " + activePlayer.getName() + " взял все карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
