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
		System.out.println(rp.x+" "+rp.y+" "+rp.x2+" "+rp.y2+ " " + (rp.x2-rp.x) +" " +(rp.y2-rp.y));
		BufferedImage rgbimage=new BufferedImage(rp.buffer.getWidth(),rp.buffer.getHeight(),BufferedImage.TYPE_3BYTE_BGR);//.getSubimage(rp.x,rp.y,rp.x2-rp.x ,rp.y2-rp.y);
		ColorConvertOp op = new ColorConvertOp(null);
		op.filter(rp.buffer,rgbimage);
/*		if(rp.heightResized){
			rp.x += w-rp.label.getBounds().width-250;
		}*/
		BufferedImage crp = rgbimage.getSubimage(rp.x,rp.y,rp.x2-rp.x ,rp.y2-rp.y);
		//image =  rp.img.getSubimage(rp.x,rp.y,rp.x2 ,rp.y2); //fill in the corners of the desired crop location here


		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		File file = new File("D:/test/" + rp.userChoice);
		file.mkdir();
		System.out.println("D:/test/"+ rp.userChoice + "/" + rp.userChoice + "_" + dtf.format(now) + ".jpg");
		File outputfile= new File("D:/test/"+ rp.userChoice + "/" + rp.userChoice + "_" + dtf.format(now) + ".jpg");
		ImageIO.write(crp, "jpg", outputfile);

		System.out.println("Cropped Image created successfully");

	/*Area mask=new Area(new Rectangle(0,0,rp.getWidth(),rp.getHeight()));
	Area aux=new Area(new Rectangle(106,91,377,380));
	mask.subtract(aux);
	rp.repaint();*/
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

