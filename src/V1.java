import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JList;

import org.openide.awt.DropDownButtonFactory;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


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
		 
		JMenuItem menuItemCreateSpringProject = new JMenuItem("Spring Project");
		popupMenu.add(menuItemCreateSpringProject);
		 
		JMenuItem menuItemCreateHibernateProject = new JMenuItem("Hibernate Project");
		popupMenu.add(menuItemCreateHibernateProject);
		 
		JMenuItem menuItemCreateStrutsProject = new JMenuItem("Struts Project");
		popupMenu.add(menuItemCreateStrutsProject);
		
		return popupMenu;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1050, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(103, 0, frame.getBounds().width, frame.getBounds().height);
		frame.getContentPane().add(desktopPane);
		desktopPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				 if (e.getSource() == frame) {

				        desktopPane.setBounds(103, 0, frame.getBounds().width, frame.getBounds().height);
			}
		}});
		
		JDesktopPane desktopPane_left = new JDesktopPane();
		desktopPane_left.setBackground(Color.LIGHT_GRAY);
		desktopPane_left.setBounds(0, 0, 103, frame.getBounds().height);
		frame.getContentPane().add(desktopPane_left);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(10, 11, 89, 23);
		desktopPane_left.add(btnAdd);
		
		JPopupMenu popupMenu = createDropDownMenu(); // created above
		ImageIcon icon = new ImageIcon("D:\\work\\1304B\\PIP-Pr_1304B_2022\\src\\test.png");
		JButton dropDownButton = DropDownButtonFactory.createDropDownButton(icon, popupMenu);
		dropDownButton.setBounds(10, 50, 89, 23);
		desktopPane_left.add(dropDownButton);
		
		frame.revalidate();


	}
}
