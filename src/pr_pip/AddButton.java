package pr_pip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AddButton {
    public JButton btnAdd;

    public void addButtonInit(DesktopPaneLeft dsktPane){
    	
        btnAdd = new JButton("ADD");
        btnAdd.setBounds((dsktPane.desktopPaneLeft.getBounds().width / 2)-30, 22, 120, 30);
        dsktPane.desktopPaneLeft.add(btnAdd);
    }
    
    void imageLoad(DesktopPaneRight dsktPane, MainFrame frm)  
	 {
    	
    	
		Image Image1;
		FileDialog fd = new FileDialog(frm.frame, "Open", FileDialog.LOAD);
	  fd.show();  
	  if (fd.getFile() != null)    
	  {  
	   String d = (fd.getDirectory() + fd.getFile());
	   
	   Toolkit toolkit = Toolkit.getDefaultToolkit(); 
	   
	   dsktPane.label.setBounds(0, 0, dsktPane.desktopPaneRight.getBounds().width, dsktPane.desktopPaneRight.getBounds().height);
	   Image1 = toolkit.getImage(d);
 
	   try {
		BufferedImage Image=ImageIO.read(new File(d));
		int w=Image.getWidth();
		int h=Image.getHeight();
		if( w>dsktPane.label.getBounds().width)
			{
			w=dsktPane.label.getBounds().width;
			h=h-(w-dsktPane.label.getBounds().width);
			}
		if( h>dsktPane.label.getBounds().height)
			{
			h=dsktPane.label.getBounds().height;
			w=w-(h-dsktPane.label.getBounds().height);
			}
		
		Image1 = toolkit.getImage(d).getScaledInstance(w, h, Image.SCALE_DEFAULT);
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
	   dsktPane.label.setIcon(new ImageIcon(Image1));
	   
	   
	  }
	 }

    public void loadImage(DesktopPaneRight dsktPane, MainFrame frm)
    {
    	btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dsktPane.label.setIcon(null);
				dsktPane.label.revalidate();
				imageLoad(dsktPane, frm);
				
			}
		});
    }
}
