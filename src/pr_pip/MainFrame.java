package pr_pip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * It's a JFrame that has a method to resize itself and its components when the window is resized
 */
public class MainFrame extends JFrame{

    /**
     * This function returns the JFrame that this class is in.
     *
     * @return The JFrame object.
     */
    public JFrame getFrame(){
        return this;
    }

    /**
     * This function sets the title of the frame, makes it visible, sets the default close operation, and sets the layout
     * to null
     */
    public void frmInit(){
    	this.setTitle("Annotations App");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

    }

    /**
     * It adds a component listener to the JFrame, which listens for the JFrame to be resized, and when it is, it resizes
     * the two JPanels inside the JFrame to fit the new size of the JFrame
     *
     * @param dsktRight The RightPanel object
     * @param dsktLeft The left panel
     */
    public void frameResize(RightPanel dsktRight, DesktopPaneLeft dsktLeft){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (e.getSource() == this) {
                    dsktRight.setBounds(200, 0, getBounds().width-220, getBounds().height-50);
                    dsktLeft.setBounds(0, 0, 200, getBounds().height);
                }
            }});
        this.revalidate();
    }

}
