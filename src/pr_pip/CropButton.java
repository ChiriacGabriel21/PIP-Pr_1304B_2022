package pr_pip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CropButton {

    private String[] choiceList = {"Car","Traffic Light","Road Sign","Building","+ADD Option"};
    public JComboBox chooseFromList;


    public void cropButtonInit(DesktopPaneLeft dsktPane){
        chooseFromList = new JComboBox(choiceList);
        chooseFromList.setSelectedIndex(-1);
        chooseFromList.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2)-30, 100, 120, 30);
        dsktPane.desktopPaneLeft.add(chooseFromList);
    }

    public void addIcons(DesktopPaneLeft dsktPane){
        try {
            Image cropImage = ImageIO.read(new File("./src/images/test.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon cropIcon = new ImageIcon(cropImage);

            Image addImage = ImageIO.read(new File("./src/images/plusSign.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon addIcon = new ImageIcon(addImage);

            JLabel cropLabel = new JLabel();
            cropLabel.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2) - (120 / 2) - 25, 90, 50, 50);
            cropLabel.setIcon(cropIcon);

            JLabel addLabel = new JLabel();
            addLabel.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2) - (120 / 2) - 17, 12, 50, 50);
            addLabel.setIcon(addIcon);

            dsktPane.desktopPaneLeft.add(cropLabel);
            dsktPane.desktopPaneLeft.add(addLabel);
        }
        catch(Exception e){}
    }
}
