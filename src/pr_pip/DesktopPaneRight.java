package pr_pip;

import javax.swing.*;
import java.awt.*;

public class DesktopPaneRight {
    public JDesktopPane desktopPaneRight;

    public void desktopPaneRightInit(MainFrame frm){
        desktopPaneRight = new JDesktopPane();
        desktopPaneRight.setBackground(Color.GRAY);
        desktopPaneRight.setBounds(200, 0, frm.frame.getBounds().width, frm.frame.getBounds().height);
        frm.frame.getContentPane().add(desktopPaneRight);
    }
}
