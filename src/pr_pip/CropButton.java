package pr_pip;

import javax.swing.JButton;

public class CropButton extends JButton{

    public CropButton(String s){
        super(s);
    }
    public void cropButtonInit(DesktopPaneLeft dsktPane){

    	this.setBounds((dsktPane.getBounds().width / 2)-30, 180, 120, 30);
        dsktPane.add(this);
    }
}
