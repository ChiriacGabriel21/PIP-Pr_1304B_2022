import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSpinner;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;


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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(103, 0, 332, 261);
		frame.getContentPane().add(desktopPane);
		
		JDesktopPane desktopPane_left = new JDesktopPane();
		desktopPane_left.setBackground(Color.LIGHT_GRAY);
		desktopPane_left.setBounds(0, 0, 103, 261);
		frame.getContentPane().add(desktopPane_left);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(10, 11, 89, 23);
		desktopPane_left.add(btnAdd);
		
		
		JButton btnCrop = new JButton("CROP");
		btnCrop.setBounds(10, 45, 89, 23);
		desktopPane_left.add(btnCrop);
		
		
	}
}
