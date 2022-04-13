package pr_pip;

import javax.swing.*;
import java.awt.*;

public class DesktopPaneLeft {
    public JDesktopPane desktopPaneLeft;

    public void desktopPaneLeftInit(MainFrame frm){
        desktopPaneLeft = new JDesktopPane();
        desktopPaneLeft.setBackground(Color.LIGHT_GRAY);
        desktopPaneLeft.setBounds(0, 0, 200, frm.frame.getBounds().height);
        frm.frame.getContentPane().add(desktopPaneLeft);
    }
}
