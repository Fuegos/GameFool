import java.util.Scanner;

public class HandlerChangeCard extends HandlerSet {

    @Override
    public void work(Match match, Player activePlayer, Player enemyPlayer) {
        if (activePlayer.getRunningCard().getSuit() == "null") {
            /* Scanner in = new Scanner(System.in);
            System.out.println("Выберете карту: ");
            int num = in.nextInt();*/
            activePlayer.setRunningCard(activePlayer.extractFun(1));
            match.setLogs("Игрок " + activePlayer.getName() + " выбрал карту!");
        } else {
            if (next != null) {
                next.work(match, activePlayer, enemyPlayer);
            }
        }
    }
}
