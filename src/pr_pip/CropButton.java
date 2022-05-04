package pr_pip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class CropButton extends JButton{

    public CropButton(String s){
        super(s);
    }
    public void cropButtonInit(DesktopPaneLeft dsktPane){

    	this.setBounds((dsktPane.getBounds().width / 2)-30, 180, 120, 30);
        dsktPane.add(this);
    }
	public void CreateCropButton(RightPanel rp) throws IOException{
		
		BufferedImage rgbimage=new BufferedImage(rp.buffer.getWidth(),rp.buffer.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		ColorConvertOp op = new ColorConvertOp(null);
		op.filter(rp.buffer,rgbimage);
			rp.x *= rp.resizeFactor;
			rp.y *= rp.resizeFactor;
			rp.x2 *= rp.resizeFactor;
			rp.y2 *= rp.resizeFactor;
			
		BufferedImage crp = rgbimage.getSubimage(rp.x,rp.y,rp.x2-rp.x ,rp.y2-rp.y);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		File file = new File("D:/test/" + rp.userChoice);
		file.mkdir();
		System.out.println("D:/test/"+ rp.userChoice + "/" + rp.userChoice + "_" + dtf.format(now) + ".jpg");
		File outputfile= new File("D:/test/"+ rp.userChoice + "/" + rp.userChoice + "_" + dtf.format(now) + ".jpg");
		ImageIO.write(crp, "jpg", outputfile);

	}
	public void cropImage(RightPanel rightPanel)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					CreateCropButton(rightPanel);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}

