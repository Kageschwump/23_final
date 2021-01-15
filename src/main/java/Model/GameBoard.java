package Model;

import Squaretype.*;
import gui_fields.GUI_Field;

import java.awt.*;

public class GameBoard {
    private GUI_Field[] fields = new GUI_Field[40];
    private GameSquare[] squares = new GameSquare[40];

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
        squares[1] = new PropertySquare("Rødovrevej",1200,50,"Velkommen til Rødovrevej", Color.blue, Color.black, 1000,250,750,2250,4000,6000);
        squares[2] = new ChanceCardSquare();
        squares[3] = new PropertySquare("Hvidovrevej",1200,50,"Velkommen til Hvidovrevej", Color.blue, Color.black, 1000,250,750, 2250,4000,6000);
        squares[4] = new TaxSquare("IndkomstSkat",4000);
        squares[5] = new ShippingSquare("Scandlines", 500,4000);
        squares[6] = new PropertySquare("Roskildevej",2000,100,"Velkommen til Roskildevej", Color.orange, Color.black,1000,600,1800,5400,8000,11000);
        squares[7] = new ChanceCardSquare();
        squares[8] = new PropertySquare("Valby Langgade",2000,100,"Velkommen til Valby Langgade", Color.orange, Color.black,1000,600,1800,5400,8000,11000);
        squares[9] = new PropertySquare("Allégade",2400,150,"Velkommen til Allégade", Color.orange, Color.black,1000,800,2000,6000,9000,12000);
        squares[10] = new VisitJailSquare();
        squares[11] = new PropertySquare("Frederiksberg Allé",2800,200,"Velkommen til Frederiksberg Allé", Color.green, Color.black,2000,1000,3000,9000,12500,15000);
        squares[12] = new BrewerySquare("Squash", 100,3000);
        squares[13] = new PropertySquare("Bülowsvej",2800,200,"Velkommen til Bülowsvej", Color.green, Color.black,2000,1000,3000,9000,12500,15000);
        squares[14] = new PropertySquare("Gl. Kongevej",3200,250,"Velkommen til Gl. Kongevej", Color.green, Color.black,2000,1250,3750,10000,14000,18000);
        squares[15] = new ShippingSquare("Mols-Linien",500,4000);
        squares[16] = new PropertySquare("Bernstorffsvej",3600,300,"Velkommen til Bernstorffsvej", Color.gray, Color.black,2000,1400,4000,11000,15000,19000);
        squares[17] = new ChanceCardSquare();
        squares[18] = new PropertySquare("Hellerupvej",3600,300,"Velkommen til Hellrupvej", Color.gray, Color.black,2000,1400,4000,11000,15000,19000);
        squares[19] = new PropertySquare("Strandvejen",4000,350,"Velkommen til Strandvejen", Color.gray, Color.black,2000,1600,4400,12000,16000,20000);
        squares[20] = new ParkingSquare();
        squares[21] = new PropertySquare("Trianglen",4400,350,"Velkommen til Trianglen", Color.red, Color.black,3000,1800,5000,14000,17500,21000);
        squares[22] = new ChanceCardSquare();
        squares[23] = new PropertySquare("Østerbrogade",4400,350,"Velkommen til Østerbrogade", Color.red, Color.black,3000,1800,5000,14000,17500,21000);
        squares[24] = new PropertySquare("Grønningen",4800,400,"Velkommen til Grønningen", Color.red, Color.black,3000,2000,6000,15000,18500,22000);
        squares[25] = new ShippingSquare("Scandlines", 500,4000);
        squares[26] = new PropertySquare("Bredgade",5200,450,"Velkommen til Bredgade", Color.white, Color.black,3000,2200,6600,16000,19500,23000);
        squares[27] = new PropertySquare("Kgs. Nytorv",5200,450,"Velkommen til kgs. Nytorv", Color.white, Color.black,3000,2200,6600,16000,19500,23000);
        squares[28] = new BrewerySquare("CocaCola", 100,3000);
        squares[29] = new PropertySquare("Østergade",5600,500,"Velkommen til Østergade", Color.white, Color.black,3000,2400,7200,17000,20500,24000);
        squares[30] = new PrisonSquare();
        squares[31] = new PropertySquare("Amagertorv",6000,550,"Velkommen til Amagertorv", Color.yellow, Color.black,4000,2600,7800,18000,22000,25000);
        squares[32] = new PropertySquare("Vimmelskaftet",6000,550,"Velkommen til Vimmelskaftet", Color.yellow, Color.black,4000,2600,7800,18000,22000,25000);
        squares[33] = new ChanceCardSquare();
        squares[34] = new PropertySquare("Nygade",6400,600,"Velkommen til Nygade", Color.yellow, Color.black,4000,3000,9000,20000,24000,28000);
        squares[35] = new ShippingSquare("Scandlines", 500,4000);
        squares[36] = new ChanceCardSquare();
        squares[37] = new PropertySquare("Frederiksberggade",7000,700,"Velkommen til Frederiksberggade", Color.magenta, Color.black,4000,3500,10000,22000,26000,30000);
        squares[38] = new TaxSquare("Ekstraordinær Statsskat",2000);
        squares[39] = new PropertySquare("Rådhuspladsen",8000,1000,"Velkommen til Rådhuspladsen", Color.magenta, Color.black,4000,4000,12000,28000,34000,40000);
    }

    public GUI_Field[] getFields() {
        return fields;
    }

    public GameSquare[] getSquares() {
        return squares;
    }

}
