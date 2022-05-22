package pr_pip;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * It's a JPanel that has a JLabel on it. The JLabel is used to display the image. The JPanel is used to draw the
 * rectangles
 */
public class RightPanel extends JPanel{
    public Image img;
    public JLabel label;
    public String userChoice = "";
    public BufferedImage buffer;
    boolean weightResized = false;
    boolean heightResized = false;
    double resizeFactor;
    boolean imageLoaded=false;
    public int x, y, x2, y2;


    // The constructor of the RightPanel class. It is initializing the variables and adding the mouse listener.
    RightPanel(){
        x = y = x2 = y2 = 0;
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }


    /**
     * It creates a JLabel object, sets its bounds, and adds it to the content pane of the main frame
     *
     * @param frm The main frame of the application.
     */
    public void rightPanelInit(MainFrame frm){
        label = new JLabel();
        label.setBounds(200, 0, frm.getBounds().width-230, frm.getBounds().height-50);
        this.setBounds(200, 0, frm.getBounds().width-200, frm.getBounds().height);
        frm.getContentPane().add(this);
        frm.getContentPane().add(label);
    }

    /**
     * This function sets the start point of the line to the given x and y coordinates.
     *
     * @param x The x coordinate of the starting point.
     * @param y The y coordinate of the starting point.
     */
    public void setStartPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This function sets the end point of the line to the given x and y coordinates
     *
     * @param x The x coordinate of the end point
     * @param y The y coordinate of the end point
     */
    public void setEndPoint(int x, int y) {
        x2 = (x);
        y2 = (y);
        if(x2>this.getWidth()){
            x2=this.getWidth();
        }
        if(y2>this.getHeight()){
            y2=this.getHeight();
        }
    }

    /**
     * Draw a rectangle with the top left corner at (px,py) and the bottom right corner at (px+pw,py+ph).
     *
     * @param g The Graphics object to draw on.
     * @param x The x coordinate of the top left corner of the rectangle to be drawn.
     * @param y The y coordinate of the upper left corner of the rectangle to be drawn.
     * @param x2 The x coordinate of the second point.
     * @param y2 The y coordinate of the second point.
     */
    public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.drawRect(px, py, pw, ph);
    }

    /**
     * "MyMouseListener is a MouseAdapter that sets the start and end points of the line to be drawn when the mouse is
     * pressed and dragged, and then repaints the panel."
     *
     * The first method, mousePressed, is called when the mouse is pressed. It sets the start point of the line to be
     * drawn. The second method, mouseDragged, is called when the mouse is dragged. It sets the end point of the line to be
     * drawn and then repaints the panel. The third method, mouseReleased, is called when the mouse is released. It sets
     * the end point of the line to be drawn and then repaints the panel
     */
    class MyMouseListener extends MouseAdapter {

        /**
         * The function `mousePressed` is called when the mouse is pressed
         *
         * @param e The MouseEvent object that contains information about the mouse event.
         */
        public void mousePressed(MouseEvent e) {
            setStartPoint(e.getX(), e.getY());
        }

        /**
         * When the mouse is dragged, set the end point to the current mouse position and repaint the canvas.
         *
         * @param e The MouseEvent object that contains information about the mouse event.
         */
        public void mouseDragged(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }

        /**
         * The mouseReleased function is called when the mouse button is released
         *
         * @param e The MouseEvent object that contains information about the mouse event.
         */
        public void mouseReleased(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }
    }

    /**
     * This function is called when the user clicks on a button. It sets the userChoice variable to the button that was
     * clicked
     *
     * @param btn The button that the user will click to select their choice.
     */
    public void getUserChoice(DrawButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userChoice = btn.getSelectedItem().toString();
            }
        });
    }

    @Override
    // This function is called when the user clicks on a button. It sets the userChoice variable to the button that was
    // clicked
    protected void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        if (this.imageLoaded) {
            Graphics2D g = (Graphics2D) g2;
            g.setStroke(new BasicStroke(3));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

            switch (userChoice) {
                case "-":
                case "+ADD Option":
                    break;
                case "Car":
                    g.setColor(Color.RED);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Traffic Light":
                    g.setColor(Color.YELLOW);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Road Sign":
                    g.setColor(Color.GREEN);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Building":
                    g.setColor(Color.BLUE);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
            }


        }

    }
}
