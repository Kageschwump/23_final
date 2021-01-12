package Squaretype;

import Controller.GUIHandler;
import Model.ChanceCard;
import Model.Chancecards.*;
import Model.GameSquare;
import Model.Player;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;

import java.awt.*;

public class ChanceCardSquare extends GameSquare {

    private String name = "?";
    private String subText = "Chancen";
    private String description = "Prøv lykken, tag et kort";
    private int drawNum;
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
        chanceCards[3] = new PayCard("Vognvask og smøring","Betal","Deres bil skal have en vognvask og en smøring, betal 300 kr", -300);
        chanceCards[4] = new PayCard("Levering", "Betal", "Betal 200 kr for levering af 2 kasser øl", -200);
        chanceCards[5] = new PayCard("Reparation","Betal","Betal 3000 kr for reparation af Deres vogn",-3000);
        chanceCards[6] = new PayCard("Reparation","Betal","Betal 3000 kr for reparation af Deres vogn",-3000);
        chanceCards[7] = new PayCard("Nye dæk","Betal","De har købt 4 nye dæk til Deres vogn, betal 1000 kr",-1000);
        chanceCards[8] = new PayCard("Parkeringsbøde","Betal","De har fået en parkeringsbøde, betal 200 kr",-200);
        chanceCards[9] = new PayCard("Bilforsikring","Betal","Betal Deres bilforsikring, 1000 kr",-1000);
        chanceCards[10] = new PayCard("Rejsetold","Betal","De har været udenlands og købt for mange smøger, betal 200 kr i told",200);
        chanceCards[11] = new PayCard("Tandlæge","Betal","Tandlægeregningen er dukket op, betal 2000 kr",-2000);
        chanceCards[12] = new PayCard("Klasselotteriet","Modtag","De har vundet i klasselottteriet, modtag 500 kr",+500);
        chanceCards[13] = new PayCard("Klasselotteriet","Modtag","De har vundet i klasselottteriet, modtag 500 kr",+500);
        chanceCards[14] = new PayCard("Aktieudbytte","Modtag","De har modtaget Deres aktieudbytte. Modtag 1000 kr af banken",+1000);
        chanceCards[15] = new PayCard("Aktieudbytte","Modtag","De har modtaget Deres aktieudbytte. Modtag 1000 kr af banken",+1000);
        chanceCards[16] = new PayCard("Aktieudbytte","Modtag","De har modtaget Deres aktieudbytte. Modtag 1000 kr af banken",+1000);
        chanceCards[17] = new PayCard("Kommuneskat","Modtag","Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr",+3000);
        chanceCards[18] = new PayCard("Tipning","Modtag","De havde en række med elleve rigtige i tipning, modtag 1000 kr",+1000);
        chanceCards[19] = new PayCard("Gageforhøjelse","Modtag","Grundet dyrtiden har De fået gageforhøjelse, modtag 1000 kr",+1000);
        chanceCards[20] = new PayCard("Præmieobligation","Modtag","Deres præmieobligation er udtrykket. De modtager 1000 kr af banken",+1000);
        chanceCards[21] = new PayCard("Præmieobligation","Modtag","Deres præmieobligation er udtrykket. De modtager 1000 kr af banken",+1000);
        chanceCards[22] = new PayCard("Auktion","Modtag","De har solgt nogle gamle møbler på auktion. Modtag 1000 kr af banken",+1000);
        chanceCards[23] = new PayCard("Nyttehaven","Modtag","Værdien af egen avl fra nyttehaven udgør 200 k, som De modtager af banken",+200);
       // chanceCards[24] = new PayCard("Matador-legatet","Modtag","De modtager Matador-legatet på 40000 kr, men kun hvis Deres værdier ikke overstiger 15000kr",+40000);
        chanceCards[25] = new TransactionCard("Fødselsdag","Modtag","Det er Deres fødselsdag. Modtag af hver medspiller 200 kr",+200);
        chanceCards[26] = new TransactionCard("Fest","Modtag","De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr",+500);
        chanceCards[27] = new TransactionCard("Fest","Modtag","De skal holde fammiliefest og får et tilskud fra hver medspiller på 500 kr",+500);
        chanceCards[28] = new MoveCard("Ryk frem","Ryk","Ryk frem til START",true,0);
        chanceCards[29] = new MoveCard("Ryk frem","Ryk","Ryk frem til START",true,0);
        chanceCards[30] = new MoveCard("Ryk frem","Ryk","Ryk tre felter frem",false,+3);
        chanceCards[31] = new MoveCard("Ryk tilbage","Ryk","Ryk tre felter tilbage",false,-3);
        chanceCards[32] = new MoveCard("Ryk tilbage","Ryk","Ryk tre felter tilbage",false,-3);
        chanceCards[33] = new MoveCard("Ryk frem","Ryk","Ryk frem til Frederiksberg Allé. Hvis De passerer START, inkasserer De 4000 kr",true,11);
        //chanceCards[34] = new MoveCard("Ryk frem","Ryk","Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke af ejes af nogen kan De købe det af banken.",true)
        //chanceCards[35] = new MoveCard("Ryk frem","Ryk","Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke af ejes af nogen kan De købe det af banken.",true)
        chanceCards[36] = new MoveCard("Ryk frem","Ryk","Tag med Mols-linjen, flkyt brikken frem og hvis De passerer START inkassér da 4000 kr",true,15);
        chanceCards[37] = new MoveCard("Ryk frem","Ryk","Ryk frem til Grønningen, hvis De passerer START inkassér da 4000 kr",true,24);
        chanceCards[38] = new MoveCard("Ryk frem","Ryk","Ryk frem til Vimmelskaftet, hvis De passerer START inkassér da 4000 kr",true,32);
        //chanceCards[39] = new MoveCard("Ryk frem","Ryk","Tag med den nærmeste færge, hvis De passerer START inkassér da 4000 kr",true);
        chanceCards[40] = new MoveCard("Ryk frem","Ryk","Ryk frem til Strandvejen, inkassér 4000 kr hvis De passerer START",true,19);
        chanceCards[41] = new MoveCard("Ryk til","Ryk","Ryk frem til Rådhuspladsen",true,39);
        chanceCards[42] = new JailCard("Benådning","Frihed","I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De har brug for det",true);
        chanceCards[43] = new JailCard("Benådning","Frihed","I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De har brug for det",true);
        chanceCards[44] = new JailCard("Fængsel","Gå i fængsel","De fængsles, gå derfor i fængsel og modtag ikke 4000 kr hvis de inkasserer START",false);
        chanceCards[45] = new JailCard("Fængsel","Gå i fængsel","De fængsles, gå derfor i fængsel og modtag ikke 4000 kr hvis de inkasserer START",false);


    }

    @Override
    public void function(Player player, GUIHandler guiHandler) {
        drawNum =  (int)(Math.random() * 46);

        ChanceCard chanceCard = drawCard(drawNum);
        guiHandler.printMessage(player.getName() + " Trak et kort: " + chanceCard.getDesc());
        chanceCard.cardFunction(player);
    }

    public ChanceCard drawCard(int drawNum)
    {
        return chanceCards[drawNum];
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
