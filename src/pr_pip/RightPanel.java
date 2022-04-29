package pr_pip;

import javax.swing.*;

import java.awt.*;

public class RightPanel extends JPanel{
    public Image img;
    public JLabel label;

    public void rightPanelInit(MainFrame frm){
        label = new JLabel();
        label.setBounds(200, 0, frm.getBounds().width, frm.getBounds().height);
        this.setBounds(200, 0, frm.getBounds().width, frm.getBounds().height);
        frm.getContentPane().add(this);
        frm.getContentPane().add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
