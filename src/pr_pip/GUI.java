package pr_pip;

import java.awt.*;


public class GUI {

	private MainFrame mainFrame = new MainFrame();
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
					GUI window = new GUI();
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
	public GUI() {
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
