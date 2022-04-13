package pr_pip;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame {
    public JFrame frame;

    public JFrame getFrame(){
        return this.frame;
    }

    public void frameInit(){
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }

    public void frameResize(DesktopPaneRight dsktRight, DesktopPaneLeft dsktLeft){
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (e.getSource() == frame) {

                    dsktRight.desktopPaneRight.setBounds(200, 0, frame.getBounds().width, frame.getBounds().height);
                    dsktLeft.desktopPaneLeft.setBounds(0, 0, 200, frame.getBounds().height);
                }
            }});
        frame.revalidate();
    }

}
