public class HandlerPickUpCard extends HandlerSet {


    public HandlerPickUpCard(HandlerSet handlerSet) {
        super(handlerSet);
    }

    public HandlerPickUpCard() {

    }

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getActiveCard() != null && activePlayer.checkRepel() == false ||
                activePlayer.getWontToBeat() == false) {
            //todo взять карты стереть активные
            match.setLogs("Игрок " + activePlayer.getName() + " взял все карты!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }

    }
}
