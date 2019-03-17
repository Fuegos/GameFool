public class HandlerCheckWin extends HandlerSet {
    public String logs;


    @Override
    public void work(Match match, Player player) {
        if (player.getActiveCard() == null && player.getFun().size() == 0 &&
            match.getPack().getCard().size() == 0) {
            //todo доработать сообщение
            this.logs = "Игрок выиграл!";
        }
        else {
            if (next != null) {
                next.work(match, player);
            }
        }
    }
}
