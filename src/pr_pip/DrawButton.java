package pr_pip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DrawButton extends JButton{

    private String[] choiceList = {"Car","Traffic Light","Road Sign","Building","+ADD Option"};
    public JComboBox chooseFromList;


    public void drawButtonInit(DesktopPaneLeft dsktPane){
        chooseFromList = new JComboBox(choiceList);
        chooseFromList.setSelectedIndex(-1);
        chooseFromList.setBounds((dsktPane.getBounds().width / 2)-30, 100, 120, 30);
        dsktPane.add(chooseFromList);
    }

 
}
