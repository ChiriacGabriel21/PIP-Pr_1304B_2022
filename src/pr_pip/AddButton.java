package pr_pip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * This class is a button that loads an image from a file
 */
public class AddButton extends JButton{


	// A constructor that takes a string as a parameter.
	// This is a constructor that takes a string as a parameter.
	public AddButton(String s){
		super(s);
	}

    // Initializing the button.
    /**
     * This function sets the bounds of the button to the center of the desktop pane
     *
     * @param dsktPane The DesktopPaneLeft object that the button will be added to.
     */
    public void addButtonInit(DesktopPaneLeft dsktPane){
        this.setBounds((dsktPane.getBounds().width / 2)-30, 22, 120, 30);
        dsktPane.add(this);
    }


    // This method is loading the image from the file.
    /**
     * It loads an image from the file system and displays it in the right panel
     *
     * @param rightPanel The RightPanel object
     * @param frm the main frame of the application
     */
    void imageLoad(RightPanel rightPanel, MainFrame frm)
	 {
		FileDialog fd = new FileDialog(frm, "Open", FileDialog.LOAD);
	  	fd.show();

	  if (fd.getFile() != null)    
	  {  
	   String d = (fd.getDirectory() + fd.getFile());
	   
	   Toolkit toolkit = Toolkit.getDefaultToolkit();

		  rightPanel.img = toolkit.getImage(d);
 
	   try {
		rightPanel.buffer =ImageIO.read(new File(d));
		int w=rightPanel.buffer.getWidth();
		int h=rightPanel.buffer.getHeight();
		rightPanel.resizeFactor = 1;

		if (w > rightPanel.label.getBounds().width) {
				rightPanel.resizeFactor = (double) w / rightPanel.label.getWidth();
				rightPanel.heightResized = true;
		}
		if (h > rightPanel.label.getBounds().height) {
				rightPanel.resizeFactor = Math.max(rightPanel.resizeFactor,(double) h / rightPanel.label.getHeight());
				rightPanel.weightResized = true;
		}
		w = (int) (w / rightPanel.resizeFactor);
		h = (int) (h / rightPanel.resizeFactor);


		rightPanel.img = toolkit.getImage(d).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		rightPanel.setBounds(200, 0, w, h);
		rightPanel.repaint();
		rightPanel.revalidate();
		rightPanel.imageLoaded=true;
	} catch (IOException e) {
		e.printStackTrace();
	}

	  }
	 }

    // This method is loading the image from the file.
    /**
     * This function is used to load an image from the user's computer
     *
     * @param rightPanel The right panel of the main frame.
     * @param frm The main frame of the application
     */
    public void loadImage(RightPanel rightPanel, MainFrame frm)
    {
    	this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imageLoad(rightPanel, frm);
			}
		});
    }
}
