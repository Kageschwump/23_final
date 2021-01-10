package Model;

import Controller.ChancecardHandler;
import Squaretype.*;
import gui_fields.GUI_Field;

import java.awt.*;

public class GameBoard {
    private GUI_Field[] fields = new GUI_Field[40];
    private GameSquare[] squares = new GameSquare[40];
    private ChancecardHandler chanceCardHandler;

    public GameBoard(ChancecardHandler chanceCardHandler)
    {
        this.chanceCardHandler = chanceCardHandler;
    }

    public GUI_Field[] createFields()
    {
        for (int i = 0; i < fields.length; i++)
        {
            fields[i] = squares[i].getGuiField();
        }

        return fields;
    }

    public void createGameBoard()
    {
        squares[0] = new StartSquare();
        squares[1] = new PropertySquare("Rødovrevej",1200,50,"sut gren", Color.blue, Color.black);
        squares[2] = new ChanceCardSquare(chanceCardHandler);
        squares[3] = new PropertySquare("Hvidovrevej",1200,50,"sut gren", Color.blue, Color.black);
        squares[4] = new Taxsquare();
        squares[5] = new CorporationSquare();
        squares[6] = new PropertySquare("Roskildevej",2000,100,"sut gren", Color.orange, Color.black);
        squares[7] = new ChanceCardSquare(chanceCardHandler);
        squares[8] = new PropertySquare("Valby Langgade",2000,100,"sut gren", Color.orange, Color.black);
        squares[9] = new PropertySquare("Allégade",2400,150,"sut gren", Color.orange, Color.black);
        squares[10] = new VisitJailSquare();
        squares[11] = new PropertySquare("Frederiksberg Allé",2800,200,"sut gren", Color.green, Color.black);
        squares[12] = new CorporationSquare();
        squares[13] = new PropertySquare("Bülowsvej",2800,200,"sut gren", Color.green, Color.black);
        squares[14] = new PropertySquare("Gl. Kongevej",3200,250,"sut gren", Color.green, Color.black);
        squares[15] = new CorporationSquare();
        squares[16] = new PropertySquare("Bernstorffsvej",3600,300,"sut gren", Color.gray, Color.black);
        squares[17] = new ChanceCardSquare(chanceCardHandler);
        squares[18] = new PropertySquare("Hellerupvej",3600,300,"sut gren", Color.gray, Color.black);
        squares[19] = new PropertySquare("Strandvejen",4000,350,"sut gren", Color.gray, Color.black);
        squares[20] = new ParkingSqaure();
        squares[21] = new PropertySquare("Trianglen",4400,350,"sut gren", Color.red, Color.black);
        squares[22] = new ChanceCardSquare(chanceCardHandler);
        squares[23] = new PropertySquare("Østerbrogade",4400,350,"sut gren", Color.red, Color.black);
        squares[24] = new PropertySquare("Grønningen",4800,400,"sut gren", Color.red, Color.black);
        squares[25] = new CorporationSquare();
        squares[26] = new PropertySquare("Bredgade",5200,450,"sut gren", Color.white, Color.black);
        squares[27] = new PropertySquare("Kgs. Nytorv",5200,450,"sut gren", Color.white, Color.black);
        squares[28] = new CorporationSquare();
        squares[29] = new PropertySquare("Østergade",5600,500,"sut gren", Color.white, Color.black);
        squares[30] = new PrisonSquare();
        squares[31] = new PropertySquare("Amagertorv",6000,550,"sut gren", Color.yellow, Color.black);
        squares[32] = new PropertySquare("Vimmelskaftet",6000,550,"sut gren", Color.yellow, Color.black);
        squares[33] = new ChanceCardSquare(chanceCardHandler);
        squares[34] = new PropertySquare("Nygade",6400,600,"sut gren", Color.yellow, Color.black);
        squares[35] = new CorporationSquare();
        squares[36] = new ChanceCardSquare(chanceCardHandler);
        squares[37] = new PropertySquare("Frederiksberggade",7000,700,"sut gren", Color.magenta, Color.black);
        squares[38] = new Taxsquare();
        squares[39] = new PropertySquare("Rådhuspladsen",8000,1000,"sut gren", Color.magenta, Color.black);
    }

    public ChancecardHandler getChanceCardHandler()
    {
        return chanceCardHandler;
    }




}
