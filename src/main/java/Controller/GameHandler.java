package Controller;

import Model.Dice;
import Model.GameBoard;
import Model.RuleSet;
import Model.ShuffleCup;

public class GameHandler {

    private ShuffleCup shuffleCup;
    private GameBoard gameBoard;
    private PlayerHandler playerHandler;
    private RuleSet ruleset;
    private ChancecardHandler chanceCardHandler;

    public GameHandler(){
        this.chanceCardHandler = new ChancecardHandler();
        this.shuffleCup = new ShuffleCup();
        this.gameBoard = new GameBoard(chanceCardHandler);
        this.ruleset = new RuleSet(gameBoard, chanceCardHandler);
    }

    public void round()
    {

    }

    public void startgame()
    {
        gameBoard.getChanceCardHandler().setGameBoard(gameBoard);
        gameBoard.getChanceCardHandler().setRuleSet(ruleset);
        gameBoard.createGameBoard();


    }

    public void playerSetup(int playerCount) {
        playerHandler = new PlayerHandler(playerCount);
        int startBalance;

        switch (playerCount) {
            case 3:
                startBalance = 18;
                break;
            case 4:
                startBalance = 16;
                break;
            default:
                startBalance = 20;
        }

        for (int i = 0; i < playerCount; i++) {
            playerHandler.getPlayers()[i] = playerHandler.createPlayer(i, guiHandler.playerString("Navn"), guiHandler.playerInt("Alder"), guiHandler.guiCreateCar(), startBalance);
            guiHandler.guiAddPlayer(playerHandler.getPlayers()[i].getGuiPlayer());

        }
    }



}
