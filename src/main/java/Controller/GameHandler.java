package Controller;

import Model.*;

public class GameHandler {

    private ShuffleCup shuffleCup;
    private GameBoard gameBoard;
    private PlayerHandler playerHandler;
    private RuleSet ruleset;
    private ChancecardHandler chanceCardHandler;
    private GUIHandler guiHandler;

    public GameHandler(){
        this.chanceCardHandler = new ChancecardHandler();
        this.shuffleCup = new ShuffleCup();
        this.gameBoard = new GameBoard(chanceCardHandler);
        this.ruleset = new RuleSet(gameBoard, chanceCardHandler);
    }

    public void round(Player player)
    {
        shuffleCup.roll();
        int faceValue1 = shuffleCup.getDice1().getFaceValue();
        int faceValue2 = shuffleCup.getDice2().getFaceValue();
        guiHandler.playerRoll(player.getName());
        guiHandler.getRoll(faceValue1, faceValue2);
        guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getFields()[player.getPlacement()]);
        playerHandler.updatePlacement(shuffleCup.getValue(), player);
        if(gameBoard.getSquares()[player.getPlacement()]==gameBoard.getSquares()[30])
        {
            gameBoard.getSquares()[player.getPlacement()].function(player);
            guiHandler.printMessage(gameBoard.getSquares()[30].getDesc());
            gameBoard.getFields()[player.getPlacement()].setCar(player.getGuiPlayer(),true);
        }
        else {
            gameBoard.getSquares()[player.getPlacement()].function(player);
            gameBoard.getFields()[player.getPlacement()].setCar(player.getGuiPlayer(), true);
            guiHandler.printMessage(gameBoard.getSquares()[player.getPlacement()].getDesc());
        }
    }

    public void startGame()
    {
        gameBoard.getChanceCardHandler().setGameBoard(gameBoard);
        gameBoard.getChanceCardHandler().setRuleSet(ruleset);
        gameBoard.createGameBoard();
        guiHandler = new GUIHandler(gameBoard.createFields());
        gameBoard.getChanceCardHandler().setGuiHandler(guiHandler);
        gameBoard.getChanceCardHandler().createCards();
        playerSetup(guiHandler.playerCount());
        int starter = ruleset.determineStarter(playerHandler.getPlayers());
        guiHandler.printMessage(playerHandler.getPlayers()[starter].getName() + " starter");

        for(int i = 0; i < playerHandler.getPlayers().length; i++) {
            gameBoard.getFields()[0].setCar(playerHandler.getPlayers()[i].getGuiPlayer(),true);
        }

        while (!ruleset.gameOver(playerHandler.getPlayers())) {

            round(playerHandler.getPlayers()[starter]);
            starter++;
            if(starter >= playerHandler.getPlayers().length)
            {
                starter = 0;
            }
        }
        // Determine winner metoden skal laves om
        guiHandler.printMessage(ruleset.determineWinner(playerHandler.getPlayers()).getName() + " vandt!!!");

    }

    public void playerSetup(int playerCount) {
        playerHandler = new PlayerHandler(playerCount);

        for (int i = 0; i < playerCount; i++) {
            playerHandler.getPlayers()[i] = playerHandler.createPlayer(i, guiHandler.playerString("Navn"), guiHandler.playerInt("Alder"), guiHandler.guiCreateCar(), 30000);
            guiHandler.guiAddPlayer(playerHandler.getPlayers()[i].getGuiPlayer());

        }
    }



}
