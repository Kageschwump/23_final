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
        this.gameBoard = new GameBoard();
        gameBoard.createGameBoard();
        guiHandler = new GUIHandler(gameBoard.createFields());
        this.ruleset = new RuleSet(gameBoard, chanceCardHandler);

    }

    public void round(Player player)
    {
        // Fængsel eller ikke fængsel

        shuffleCup.roll();
        int faceValue1 = shuffleCup.getDice1().getFaceValue();
        int faceValue2 = shuffleCup.getDice2().getFaceValue();
        int facevalue = faceValue1 + faceValue2;
        player.setLastRoll(facevalue);

        if(player.isPrison())
        {
            if(player.getAccount().getBalance() < 1000) {
                facevalue = ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger"), faceValue1, faceValue2);
            }else
                {
                    facevalue = ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger", "Betal"), faceValue1, faceValue2);
                }
        }
        guiHandler.playerRoll(player.getName());
        guiHandler.getRoll(faceValue1, faceValue2);
        guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getFields()[player.getPlacement()]);
        playerHandler.updatePlacement(facevalue, player);
        gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
    }

    public void startGame()
    {
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
