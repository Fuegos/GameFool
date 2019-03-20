import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyWindowApp extends JFrame{
    private static JLabel countLabel;
    private static JLabel cardPlayerOne;
    private static JLabel cardPlayerTwo;
    private static JComboBox comboBoxPlayerOne;
    private static JComboBox comboBoxPlayerTwo;
    private static JButton playerOneButton;
    private static JButton playerTwoButton;
    private static JLabel picLabelOne;
    private static JLabel picLabelTwo;


    public MyWindowApp() {
        super("Пикник с дураком");
        setBounds(100, 100, 900, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        super.add(panel);


        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("Локация.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);


        countLabel = new JLabel("Логи партии");
        countLabel.setBounds(300, 470, 300, 20);
        countLabel.setForeground(Color.black);
        picLabel.add(countLabel);


        BufferedImage playerOnePicture = null;
        try {
            playerOnePicture = ImageIO.read(new File("кошка.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        picLabelOne = new JLabel(new ImageIcon(playerOnePicture));
        picLabelOne.setBounds(20, 370, 250, 250);
        picLabel.add(picLabelOne);


        BufferedImage playerTwoPicture = null;
        try {
            playerTwoPicture = ImageIO.read(new File("лось.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        picLabelTwo = new JLabel(new ImageIcon(playerTwoPicture));
        picLabelTwo.setBounds(680, 280, 250, 250);
        picLabel.add(picLabelTwo);


        cardPlayerOne = new JLabel("");
        cardPlayerOne.setBounds(290, 280, 200, 20);
        cardPlayerOne.setForeground(Color.black);
        picLabel.add(cardPlayerOne);

        cardPlayerTwo = new JLabel("");
        cardPlayerTwo.setBounds(550, 280, 200, 20);
        cardPlayerTwo.setForeground(Color.black);
        picLabel.add(cardPlayerTwo);

        comboBoxPlayerOne = new JComboBox();
        comboBoxPlayerOne.setBounds(15, 155, 200, 20);
        picLabel.add(comboBoxPlayerOne);
        comboBoxPlayerTwo = new JComboBox();
        comboBoxPlayerTwo.setBounds(690, 155, 200, 20);
        picLabel.add(comboBoxPlayerTwo);

        playerOneButton = new JButton("Кинуть");
        playerOneButton.setBounds(60, 120, 100, 30);
        picLabel.add(playerOneButton);
        playerTwoButton = new JButton("Кинуть");
        playerTwoButton.setBounds(740, 120, 100, 30);
        picLabel.add(playerTwoButton);
    }


    public static void printDateGUI(Player playerOne, Player playerTwo, Match match) {
        comboBoxPlayerOne.removeAllItems();
        for(int i = 0; i < playerOne.getFun().size(); i++) {
            comboBoxPlayerOne.addItem(playerOne.getFun().get(i).getPhrase());
        }
        comboBoxPlayerOne.addItem("Отменить ход");
        comboBoxPlayerTwo.removeAllItems();
        for(int i = 0; i < playerTwo.getFun().size(); i++) {
            comboBoxPlayerTwo.addItem(playerTwo.getFun().get(i).getPhrase());
        }
        comboBoxPlayerTwo.addItem("Отменить ход");
        countLabel.setText(match.getLogs());
        if(match.getActivePlayer() == playerOne.getName()) {
            picLabelOne.setVisible(true);
            picLabelTwo.setVisible(false);
            comboBoxPlayerOne.setEnabled(true);
            comboBoxPlayerTwo.setEnabled(false);
            playerOneButton.setEnabled(true);
            playerTwoButton.setEnabled(false);

        }
        else if (match.getActivePlayer() == playerTwo.getName()) {
            picLabelOne.setVisible(false);
            picLabelTwo.setVisible(true);
            comboBoxPlayerOne.setEnabled(false);
            comboBoxPlayerTwo.setEnabled(true);
            playerOneButton.setEnabled(false);
            playerTwoButton.setEnabled(true);
        }
    }


    public static void main(String[] args) {
        MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
        app.setVisible(true);

        HandlerSet handlerPickUpCard = new HandlerPickUpCard();
        HandlerSet handlerRepelCard = new HandlerRepelCard(handlerPickUpCard);
        HandlerSet handlerCloseSet = new HandlerCloseSet(handlerRepelCard);
        HandlerSet handlerTossCard = new HandlerTossCard(handlerCloseSet);
        HandlerSet handlerPutCard = new HandlerPutCard(handlerTossCard);
        HandlerSet handlerCheckWin = new HandlerCheckWin(handlerPutCard);

        Match match = new Match();
        match.createPack("36");

        Player playerOne = new Player("1");
        Player playerTwo = new Player("2");
        playerOne.createFun(match.getPack());
        playerTwo.createFun(match.getPack());

        Observer systemPutCardIntoFun = new SystemPutCardIntoFun();
        match.attach(systemPutCardIntoFun);
        match.setActive(playerOne.getName());
        match.setActivePlayer(playerOne);
        printDateGUI(playerOne, playerTwo, match);

        while (match.getWinPlayer() != null) {
            printDateGUI(playerOne, playerTwo, match);
            if (match.getActivePlayer() == playerOne.getName())
                handlerCheckWin.work(match, playerOne, playerTwo);
            else
                handlerCheckWin.work(match, playerTwo, playerOne);
        }

        playerOneButton.addActionListener(e -> {
            int index = comboBoxPlayerOne.getSelectedIndex();
            if (index == playerOne.getFun().size()) {
                playerOne.setActiveCard(new FactoryCardExotic().createCard("отмена"));
            }
            else {
                playerOne.setActiveCard(playerOne.extractFun(index));
            }
            cardPlayerOne.setText(playerOne.getActiveCard().getPhrase());
            if (match.getActivePlayer() == playerOne.getName())
                handlerCheckWin.work(match, playerOne, playerTwo);
            else
                handlerCheckWin.work(match, playerTwo, playerOne);
            printDateGUI(playerOne, playerTwo, match);
        });

        playerTwoButton.addActionListener(e -> {
            int index = comboBoxPlayerTwo.getSelectedIndex();
            if (index == playerTwo.getFun().size()) {
                playerTwo.setActiveCard(new FactoryCardExotic().createCard("отмена"));
            }
            else {
                playerTwo.setActiveCard(playerTwo.extractFun(index));
            }
            cardPlayerTwo.setText(playerTwo.getActiveCard().getPhrase());
            if (match.getActivePlayer() == playerOne.getName())
                handlerCheckWin.work(match, playerOne, playerTwo);
            else
                handlerCheckWin.work(match, playerTwo, playerOne);
            printDateGUI(playerOne, playerTwo, match);
        });
    }
}
