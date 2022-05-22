package pr_pip;

import java.awt.*;


/**
 * This class is the main class of the program. It initializes the main frame, the desktop pane, the right panel, the add
 * button, the draw button, and the crop button. It also adds the icons to the desktop pane
 */
public class GUI {
	private String[] choiceList = {"-","Car","Traffic Light","Road Sign","Building","+ADD Option"};

	private MainFrame mainFrame = new MainFrame();
	private DesktopPaneLeft paneLeft = new DesktopPaneLeft();
	private RightPanel rightPanel = new RightPanel();
	private AddButton addButton = new AddButton("ADD IMAGE");
	private DrawButton drawButton = new DrawButton(choiceList);
	private CropButton cropButton = new CropButton("CROP IMAGE");

	/**
	 * Launch the application.
	 */
	/**
	 * This function is used to create the GUI and make it visible
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	// A constructor. It is called when an object of the class is created.
	public GUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * It initializes the main frame, the right panel, the left panel, the add button, the draw button, and the crop button
	 */
	private void initialize() {
		mainFrame.frmInit();
		rightPanel.rightPanelInit(mainFrame);
		paneLeft.desktopPaneLeftInit(mainFrame);
		addButton.addButtonInit(paneLeft);
		drawButton.drawButtonInit(paneLeft);
		cropButton.cropButtonInit(paneLeft);
		
		
		mainFrame.frameResize(rightPanel, paneLeft);

		paneLeft.addIcons();
		
		addButton.loadImage(rightPanel, mainFrame);
		cropButton.cropImage(rightPanel);
		rightPanel.getUserChoice(drawButton);
		
	}
}
