package pr_pip;

import javax.swing.JButton;

public class CropButton {
    public JButton btnCrop;

    public void cropButtonInit(DesktopPaneLeft dsktPane){
    	
    	btnCrop = new JButton("CROP");
    	btnCrop.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2)-30, 180, 120, 30);
        dsktPane.desktopPaneLeft.add(btnCrop);
    }
}
