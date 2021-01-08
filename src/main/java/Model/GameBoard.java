package Model;

import gui_fields.GUI_Field;

public class GameBoard {
    private GUI_Field[] fields = new GUI_Field[24];
    private GameSquare[] squares = new GameSquare[24];

    public GUI_Field[] createFields()
    {
        for (int i = 0; i < fields.length; i++)
        {
            fields[i] = squares[i].getGuiField();
        }

        return fields;
    }


}
