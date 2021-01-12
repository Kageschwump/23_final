package Model;

import Controller.ChancecardHandler;
import Controller.GUIHandler;
import Squaretype.*;
import gui_fields.GUI_Field;

import java.awt.*;

public class GameBoard {
    private GUI_Field[] fields = new GUI_Field[40];
    private GameSquare[] squares = new GameSquare[40];
    private GUIHandler guiHandler;

    public GameBoard()
    {

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
        squares[1] = new PropertySquare("Rødovrevej",1200,50,"sut gren", Color.blue, Color.black, guiHandler);
        squares[2] = new ChanceCardSquare();
        squares[3] = new PropertySquare("Hvidovrevej",1200,50,"sut gren", Color.blue, Color.black, guiHandler);
        squares[4] = new TaxSquare();
        squares[5] = new ShippingSquare("Scandlines", "500");
        squares[6] = new PropertySquare("Roskildevej",2000,100,"sut gren", Color.orange, Color.black, guiHandler);
        squares[7] = new ChanceCardSquare();
        squares[8] = new PropertySquare("Valby Langgade",2000,100,"sut gren", Color.orange, Color.black, guiHandler);
        squares[9] = new PropertySquare("Allégade",2400,150,"sut gren", Color.orange, Color.black, guiHandler);
        squares[10] = new VisitJailSquare();
        squares[11] = new PropertySquare("Frederiksberg Allé",2800,200,"sut gren", Color.green, Color.black, guiHandler);
        squares[12] = new BrewerySquare("Squash", "100");
        squares[13] = new PropertySquare("Bülowsvej",2800,200,"sut gren", Color.green, Color.black, guiHandler);
        squares[14] = new PropertySquare("Gl. Kongevej",3200,250,"sut gren", Color.green, Color.black, guiHandler);
        squares[15] = new ShippingSquare("Mols-Linien", "500");
        squares[16] = new PropertySquare("Bernstorffsvej",3600,300,"sut gren", Color.gray, Color.black, guiHandler);
        squares[17] = new ChanceCardSquare();
        squares[18] = new PropertySquare("Hellerupvej",3600,300,"sut gren", Color.gray, Color.black, guiHandler);
        squares[19] = new PropertySquare("Strandvejen",4000,350,"sut gren", Color.gray, Color.black, guiHandler);
        squares[20] = new ParkingSquare();
        squares[21] = new PropertySquare("Trianglen",4400,350,"sut gren", Color.red, Color.black, guiHandler);
        squares[22] = new ChanceCardSquare();
        squares[23] = new PropertySquare("Østerbrogade",4400,350,"sut gren", Color.red, Color.black, guiHandler);
        squares[24] = new PropertySquare("Grønningen",4800,400,"sut gren", Color.red, Color.black, guiHandler);
        squares[25] = new ShippingSquare("Scandlines", "500");
        squares[26] = new PropertySquare("Bredgade",5200,450,"sut gren", Color.white, Color.black, guiHandler);
        squares[27] = new PropertySquare("Kgs. Nytorv",5200,450,"sut gren", Color.white, Color.black, guiHandler);
        squares[28] = new BrewerySquare("CocaCola", "100");
        squares[29] = new PropertySquare("Østergade",5600,500,"sut gren", Color.white, Color.black, guiHandler);
        squares[30] = new PrisonSquare();
        squares[31] = new PropertySquare("Amagertorv",6000,550,"sut gren", Color.yellow, Color.black, guiHandler);
        squares[32] = new PropertySquare("Vimmelskaftet",6000,550,"sut gren", Color.yellow, Color.black, guiHandler);
        squares[33] = new ChanceCardSquare();
        squares[34] = new PropertySquare("Nygade",6400,600,"sut gren", Color.yellow, Color.black, guiHandler);
        squares[35] = new ShippingSquare("Scandlines", "500");
        squares[36] = new ChanceCardSquare();
        squares[37] = new PropertySquare("Frederiksberggade",7000,700,"sut gren", Color.magenta, Color.black, guiHandler);
        squares[38] = new TaxSquare();
        squares[39] = new PropertySquare("Rådhuspladsen",8000,1000,"sut gren", Color.magenta, Color.black, guiHandler);
    }


    public GUI_Field[] getFields() {
        return fields;
    }

    public GameSquare[] getSquares() {
        return squares;
    }






}
