package pr_pip;

import javax.swing.*;

public class AddButton {
    public JButton btnAdd;

    public void addButtonInit(DesktopPaneLeft dsktPane){
        btnAdd = new JButton("ADD");
        btnAdd.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2)-30, 22, 120, 30);
        dsktPane.desktopPaneLeft.add(btnAdd);
    }

}
