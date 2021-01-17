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
                    haveRolled = true;
                    break;

                case "Sælg":
                    playerChoice = guiHandler.getGui().getUserButtonPressed("Hvad vil du sælge?", "Hus", "Ejendom");
                    if (playerChoice.equals("Hus")) {
                        sellHouse(player);
                    } else if (playerChoice.equals("Ejendom")) {
                        sellProperty(player);
                    }
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

    public void sellProperty(Player player) {
        int counter = 0;
        String prop;
        int numOfPropWithoutHouses;
        String[] properties = new String[player.getAccount().amountOfProperties()];

        if (player.getAccount().amountOfProperties() > 0) {
            int u = 0;
            int o = 0;
            if(player.getAccount().getProperties()[o][0] != null){
                properties[u] = player.getAccount().getProperties()[o][0];
                o++;
                u++;
            }
            else if(player.getAccount().getProperties() == null){
                o++;
            }
            else if(o >= player.getAccount().getProperties().length){

            }

            numOfPropWithoutHouses = gameBoard.findPlayerProperties(properties).length - gameBoard.playerPropWithHouses(properties).length;
            String[] choices = new String[numOfPropWithoutHouses];
            counter = 0;
            for (int i = 0; i < numOfPropWithoutHouses; i++) {
                if(gameBoard.playerPropWithHouses(properties).length == 0) {
                    choices[counter] = gameBoard.findPlayerProperties(properties)[i].getName();
                    counter++;
                }
                else if(gameBoard.playerPropWithHouses(properties).length != 0) {
                    if (gameBoard.findPlayerProperties(properties)[i].getName() != gameBoard.playerPropWithHouses(properties)[counter].getName()) {
                        choices[counter] = gameBoard.findPlayerProperties(properties)[i].getName();
                        counter++;
                    }
                }
            }

            prop = guiHandler.getGui().getUserSelection("Hvilken ejendom vil du sælge?", choices);
            player.getAccount().deleteProperty(prop);
            gameBoard.resetOwnership(prop);
        }
        else{
            guiHandler.printMessage("Du har ingen ejendomme at sælge");
        }
    }

    public void sellHouse(Player player) {
        if (player.getAccount().numOfHouses() > 0 || player.getAccount().numOfHotels() > 0) {

            int counter = 0;
            String[] playerProps = new String[player.getAccount().amountOfProperties()];

            if (player.getAccount().amountOfProperties() > 0) {
                int u = 0;
                int o = 0;
                if (player.getAccount().getProperties()[o][0] != null) {
                    playerProps[u] = player.getAccount().getProperties()[o][0];
                    o++;
                    u++;
                } else if (player.getAccount().getProperties() == null) {
                    o++;
                } else if (o >= player.getAccount().getProperties().length) {

                }


                    //for (int i = 0; i < gameBoard.getSquares().length; i++) {
                    //   if (gameBoard.getSquares()[i].getName().equals(player.getAccount().getProperties()[counter][0])) {
                    //      playerProps[counter] = gameBoard.getSquares()[i].getName();
                    //       counter++;
                    //   }
                    //}

                    PropertySquare[] propertySquares = gameBoard.playerPropWithHouses(playerProps);
                    String[] playerPropsWithHouses = new String[propertySquares.length];
                    for (int x = 0; x < propertySquares.length; x++) {
                        playerPropsWithHouses[x] = propertySquares[x].getName();
                    }
                    String prop = guiHandler.getGui().getUserSelection("Hvilken ejendom vil du sælge et hus fra?", playerPropsWithHouses);
                    gameBoard.findProp(prop).sellHouses(1);

                } else {
                    guiHandler.printMessage("Du har ingen huse at sælge");
                }
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
            guiHandler.resetCars(player, playerHandler.getPlayers(), gameBoard.getFields()[lastPlacement]);
            guiHandler.resetCars(player, playerHandler.getPlayers(), gameBoard.getFields()[player.getPlacement()]);
            lastPlacement = player.getPlacement();
            gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
            if(player.getPlacement() != lastPlacement) {
                guiHandler.resetCars(player, playerHandler.getPlayers(), gameBoard.getFields()[lastPlacement]);
                guiHandler.resetCars(player, playerHandler.getPlayers(), gameBoard.getFields()[player.getPlacement()]);
                gameBoard.getSquares()[player.getPlacement()].function(player, guiHandler);
            }
        }
    }
}
