package pr_pip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AddButton extends JButton{


	public AddButton(String s){
		super(s);
	}

    public void addButtonInit(DesktopPaneLeft dsktPane){
        this.setBounds((dsktPane.getBounds().width / 2)-30, 22, 120, 30);
        dsktPane.add(this);
    }

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
		if( w>rightPanel.label.getBounds().width)
			{
				h=h-(w-rightPanel.label.getBounds().width-250)-250;
				w=rightPanel.label.getBounds().width-250;
				rightPanel.heightResized = true;
			}
			if( h>rightPanel.label.getBounds().height)
			{
				w=w-(h-rightPanel.label.getBounds().height-250)-250;
				h=rightPanel.label.getBounds().height-250;
				rightPanel.weightResized = true;
			}
		   rightPanel.img = toolkit.getImage(d).getScaledInstance(w, h, Image.SCALE_DEFAULT);
		   rightPanel.setBounds(200, 0, w, h);
		   rightPanel.repaint();
		   rightPanel.revalidate();
	} catch (IOException e) {
		e.printStackTrace();
	}

	  }
	 }

    public void loadImage(RightPanel rightPanel, MainFrame frm)
    {
    	this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imageLoad(rightPanel, frm);
			}
		});
    }
}
