package Model;

import Controller.GUIHandler;
import gui_fields.GUI_Field;

import java.awt.*;

public abstract class GameSquare {
    public abstract String function(Player player, GUIHandler guiHandler);

    public abstract String getName();

    public abstract GUI_Field getGuiField();

    public abstract String getDesc();

    public abstract Color getColor();
}

