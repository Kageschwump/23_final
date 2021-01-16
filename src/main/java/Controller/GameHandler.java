package Controller;

import Model.*;
import Squaretype.PropertySquare;

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
        this.ruleset = new RuleSet(gameBoard, chanceCardHandler, guiHandler, shuffleCup);
    }

    public void round(Player player)
    {
        shuffleCup.roll();
        int faceValue1 = shuffleCup.getDice1().getFaceValue();
        int faceValue2 = shuffleCup.getDice2().getFaceValue();
        int facevalue = faceValue1 + faceValue2;
        player.setLastRoll(facevalue);

        // Fængsel eller ikke fængsel
        if(player.isPrison())
        {
            if(player.getAccount().getBalance() < 1000) {
                facevalue = ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger"), faceValue1, faceValue2);
            }else
            {
                facevalue = ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger", "Betal"), faceValue1, faceValue2);
            }
        }else
            {
                guiHandler.playerRoll(player.getName());
                guiHandler.getRoll(faceValue1, faceValue2);
            }

        guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getFields()[player.getPlacement()]);
        player.updatePlacement(facevalue);
        int lastPlacement = player.getPlacement();
        gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
        if(player.getPlacement() != lastPlacement)
        {
            guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getSquares()[lastPlacement].getGuiField());
            guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getFields()[player.getPlacement()]);
            gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
        }
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

    public void sellProperty(Player player)
    {
        String playerOption = null;
        String[] properties = new String[player.getAccount().getProperties().length];
        String prop;
        int counter = 0;
        if(player.getAccount().getBalance() > 0)
        {
            playerOption = guiHandler.getGui().getUserButtonPressed("Hvad vil du sælge?\n Du modtager halvdelen af ejendommens eller husets pris", "Ejendom", "Huse", "Rul");

        }else if(player.getAccount().amountOfProperties() < 0)
            {
                playerOption = guiHandler.getGui().getUserButtonPressed("Hvad vil du sælge?\n Du modtager halvdelen af ejendommens eller husets pris", "Ejendom", "Huse");
            }
        switch (playerOption)
        {
            case "Ejendom":

                for(int i = 0; i < player.getAccount().getProperties().length; i++)
                {
                    if(player.getAccount().getProperties()[i][0] != null)
                    {
                        properties[counter] = player.getAccount().getProperties()[i][0];
                        counter++;
                    }
                }
                prop = guiHandler.getGui().getUserSelection("Hvilken ejendom?",properties);
                player.getAccount().deleteProperty(prop);
                gameBoard.resetOwnership(prop);
                break;
            case "Huse":

                PropertySquare[] ownedSquares = new PropertySquare[player.getAccount().amountOfProperties()];


                for(int i = 0; i < gameBoard.getSquares().length; i++)
                {
                    if(gameBoard.getSquares()[i].getName().equals(player.getAccount().getProperties()[i][0]))
                    {
                        if(ownedSquares[counter].getHouses() > 0)
                        {
                            ownedSquares[counter] = (PropertySquare) gameBoard.getSquares()[i];
                        }
                        counter++;
                    }
                }
                prop = guiHandler.getGui().getUserSelection("Hvilken ejendom?",properties);
                for(int i = 0; i < properties.length; i++)
                {
                    if(prop.equals(properties[i]))
                    {
                        ownedSquares[i].sellHouses();
                    }
                }

                break;
            case "Rul":

        }
    }
}
