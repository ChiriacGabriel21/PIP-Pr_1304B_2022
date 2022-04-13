import pr_pip.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;


public class V1 {

	private mainFrame mainFrame = new mainFrame();
	private DesktopPaneLeft paneLeft = new DesktopPaneLeft();
	private DesktopPaneRight paneRight = new DesktopPaneRight();
	private AddButton addButton = new AddButton();
	private CropButton cropButton = new CropButton();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 window = new V1();
					window.mainFrame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public V1() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame.frameInit();
		paneRight.desktopPaneRightInit(mainFrame);
		paneLeft.desktopPaneLeftInit(mainFrame);
		addButton.addButtonInit(paneLeft);
		cropButton.cropButtonInit(paneLeft);

		mainFrame.frameResize(paneRight, paneLeft);

		cropButton.addIcons(paneLeft);
	}
}
