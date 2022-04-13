package pr_pip;

import javax.swing.*;

import java.awt.*;

public class DesktopPaneRight {
    public JDesktopPane desktopPaneRight;
    public JLabel label;
    

    public void desktopPaneRightInit(MainFrame frm){
    	label=new JLabel();
        desktopPaneRight = new JDesktopPane();
        desktopPaneRight.setBackground(Color.GRAY);
        desktopPaneRight.setBounds(200, 0, frm.frame.getBounds().width, frm.frame.getBounds().height);
        frm.frame.getContentPane().add(desktopPaneRight);
        desktopPaneRight.add(label);
    }
}
