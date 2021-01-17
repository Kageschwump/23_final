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
        String playerChoice = "";
        boolean haveRolled = false;
        player.setLastRoll(faceValue1+faceValue2);

        guiHandler.printMessage(player.getName() +"'s tur!");
        // Fængsel eller ikke fængsel
        if(player.isPrison())
        {
            guiHandler.printMessage("Du er i fængsel");
            if(player.getAccount().getBalance() < 1000) {
                ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger"), faceValue1, faceValue2);
            }
            else {
                ruleset.prisonEscape(player, guiHandler.getGui().getUserButtonPressed("Hvordan vil du komme ud af fængsel?", "Terninger", "Betal"), faceValue1, faceValue2);
            }
        }

        while (!haveRolled && !player.isPrison()){
            playerChoice = guiHandler.getGui().getUserButtonPressed("Hvad vil du foretage dig?", "Rul", "Sælg");
            switch (playerChoice) {
                case "Rul":
                    playersRound(player, faceValue1, faceValue2);
                    if(player.getAccount().getBalance() < 0)
                    {
                        if(player.getAccount().getProperties().length > 0)
                        {
                            guiHandler.printMessage(player.getName() +" er gået konkurs! Du bliver nødt til at sælge ejendomme!");
                            while (player.getAccount().getBalance() < 0 && player.getAccount().getProperties().length > 0) {
                                sellProperty(player);

                                if(player.getAccount().getBalance() >= 0)
                                {
                                    break;
                                }
                            }
                        }
                    }
                    haveRolled = true;
                    break;

                case "Sælg":
                    guiHandler.printMessage("Hvilken ejendom vil du sælge? \nHvis der er huse på ejendommen bliver disse også solgt");
                        sellProperty(player);
                    break;
            }
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
            } else if(playerHandler.getPlayers()[starter].getPlayerLost())
            {
                starter++;
            }
        }
        guiHandler.printMessage(ruleset.determineWinner(playerHandler.getPlayers()).getName() + " vandt!!!");

    }

    public void playerSetup(int playerCount) {
        playerHandler = new PlayerHandler(playerCount);

        for (int i = 0; i < playerCount; i++) {
            playerHandler.getPlayers()[i] = playerHandler.createPlayer(i, guiHandler.playerString("Navn"), guiHandler.playerInt("Alder"), guiHandler.guiCreateCar(), 30000);
            guiHandler.guiAddPlayer(playerHandler.getPlayers()[i].getGuiPlayer());

        }
    }

    public void sellProperty(Player player) {
        String prop;
        String[] properties = new String[player.getAccount().amountOfProperties()];
        int u = 0;

        if (player.getAccount().amountOfProperties() > 0) {
            for (int i = 0; i < player.getAccount().getProperties().length; i++) {
                if (player.getAccount().getProperties()[i][0] != null) {
                    properties[u] = player.getAccount().getProperties()[i][0];
                    u++;
                }
            }

            prop = guiHandler.getGui().getUserSelection("Hvilken ejendom vil du sælge?", properties);
            player.getAccount().deleteProperty(prop);
            gameBoard.resetOwnership(prop);
        }
        else if(player.getAccount().getBalance() < 0){
            guiHandler.printMessage(player.getName() + " er gået fallit og er nu ude af spillet");
            gameBoard.getFields()[player.getPlacement()].setCar(player.getGuiPlayer(),false);
            playerHandler.removePlayer(player);
        }
        else{
            guiHandler.printMessage("Du har ingen ejendomme at sælge");
        }

    }

    public void playersRound(Player player, int faceValue1, int faceValue2)
    {
        guiHandler.getRoll(faceValue1, faceValue2);

        guiHandler.resetCars(player,playerHandler.getPlayers(),gameBoard.getFields()[player.getPlacement()]);
        player.setLastRoll(faceValue1+faceValue2);
        player.updatePlacement(faceValue1 + faceValue2);
        int lastPlacement = player.getPlacement();
        gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
        if(player.getPlacement() != lastPlacement) {
            gameBoard.getFields()[lastPlacement].setCar(player.getGuiPlayer(),false);
            gameBoard.getFields()[player.getPlacement()].setCar(player.getGuiPlayer(),false);
            lastPlacement = player.getPlacement();
            gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
            if(player.getPlacement() != lastPlacement) {
                gameBoard.getFields()[lastPlacement].setCar(player.getGuiPlayer(),false);
                gameBoard.getFields()[player.getPlacement()].setCar(player.getGuiPlayer(),false);
                gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
            }
        }

    }
}
