package pr_pip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * This class is a JComboBox that has a method to draw itself on the desktop pane
 */
public class DrawButton extends JComboBox{

    // A constructor that takes a String array as an argument.
    public DrawButton(String[] s){
        super(s);
    }

    /**
     * This function sets the bounds of the button to the center of the desktop pane
     *
     * @param dsktPane The DesktopPaneLeft object that the button will be added to.
     */
    public void drawButtonInit(DesktopPaneLeft dsktPane){
        this.setBounds((dsktPane.getBounds().width / 2)-30, 100, 120, 30);
        dsktPane.add(this);
    }
 
}
