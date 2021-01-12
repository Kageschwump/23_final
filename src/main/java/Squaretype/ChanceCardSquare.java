package Squaretype;

import Model.ChanceCard;
import Model.Chancecards.JailCard;
import Model.Chancecards.PayCard;
import Model.Chancecards.PriceCard;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;

import java.awt.*;

public class ChanceCardSquare extends GameSquare {

    private String name = "?";
    private String subText = "Chancen";
    private String description = "Prøv lykken, tag et kort";
    private Color bgColor = Color.orange;
    private Color fgColor = Color.black;
    private GUI_Field fieldType;
    private ChanceCard[] chanceCards = new ChanceCard[46];

    public ChanceCardSquare()
    {
        fieldType = new GUI_Chance("?", "Chancen", "prøv lykken, tag et kort", bgColor, fgColor);
        createChanceCards();
    }

    public void createChanceCards()
    {
        chanceCards[0] = new PriceCard("Oliepriser","Priser stiger", "Oliepriserne er steget, og du skal betale 500 kr pr hus og 2000 kr pr hotel",500,2000);
        chanceCards[1] = new PriceCard("Ejendomsskat","Priser stiger", "Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel",800,2300);
        chanceCards[2] = new PayCard("Fuldt stop","Betal","De har kørt frem for 'fuldt stop', betal 1000 kr i bøde", -1000);
        chanceCards[3] = new PayCard("Fuldt stop","Betal","De har kørt frem for 'fuldt stop', betal 1000 kr i bøde", -1000);
    }

    @Override
    public String function(Player player) {
        return "ChanceCardSquare";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public GUI_Field getGuiField() {
        return fieldType;
    }

    @Override
    public String getDesc() {
        return description;
    }

    @Override
    public Color getColor() {
        return bgColor;
    }
}
