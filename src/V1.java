import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JList;

import org.openide.awt.DropDownButtonFactory;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;


public class V1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 window = new V1();
					window.frame.setVisible(true);
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

	private JPopupMenu createDropDownMenu(){
		JPopupMenu popupMenu = new JPopupMenu();
		 
		JMenuItem menuItemCreateCar = new JMenuItem("Car");
		popupMenu.add(menuItemCreateCar);
		 
		JMenuItem menuItemCreateTrafficLight = new JMenuItem("Traffic Light");
		popupMenu.add(menuItemCreateTrafficLight);
		 
		JMenuItem menuItemCreateRoadSign = new JMenuItem("Road Sign");
		popupMenu.add(menuItemCreateRoadSign);

		JMenuItem menuItemCreateBuilding = new JMenuItem("Building");
		popupMenu.add(menuItemCreateBuilding);
		
		return popupMenu;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(200, 0, frame.getBounds().width, frame.getBounds().height);
		frame.getContentPane().add(desktopPane);

		JDesktopPane desktopPane_left = new JDesktopPane();
		desktopPane_left.setBackground(Color.LIGHT_GRAY);
		desktopPane_left.setBounds(0, 0, 200, frame.getBounds().height);
		frame.getContentPane().add(desktopPane_left);

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				 if (e.getSource() == frame) {

				        desktopPane.setBounds(200, 0, frame.getBounds().width, frame.getBounds().height);
					 	desktopPane_left.setBounds(0, 0, 200, frame.getBounds().height);
			}
		}});
		

		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds((desktopPane_left.getBounds().width/2) - (89/2), 11, 89, 50);
		desktopPane_left.add(btnAdd);
		
		JPopupMenu popupMenu = createDropDownMenu();
		try {
			Image image = ImageIO.read(new File("./src/test.png")).getScaledInstance(40, 40, Image.SCALE_DEFAULT);
			JButton dropDownButton = DropDownButtonFactory.createDropDownButton(new ImageIcon(image), popupMenu);
			dropDownButton.setBounds((desktopPane_left.getBounds().width/2) - (89/2), 100, 89, 50);
			desktopPane_left.add(dropDownButton);
		}
		catch(Exception e){}

		
		frame.revalidate();

	}
}
