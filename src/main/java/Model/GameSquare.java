package Model;

import Controller.ChancecardHandler;
import Controller.GUIHandler;
import gui_fields.GUI_Field;

import java.awt.*;

public abstract class GameSquare {

    private ChancecardHandler chancecardHandler = new ChancecardHandler();

    public abstract void function(Player player, GUIHandler guiHandler);

    public abstract String getName();

    public abstract GUI_Field getGuiField();

    public abstract String getDesc();

    public abstract Color getColor();


    public ChancecardHandler getChancecardHandler() {
        return chancecardHandler;
    }
}

