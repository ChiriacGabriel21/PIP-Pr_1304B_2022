import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;


public class V1 {

	private JFrame frame;
	private JDesktopPane desktopPane_right;
	private JDesktopPane desktopPane_left;

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
		desktopPane_right = new JDesktopPane();
		desktopPane_left = new JDesktopPane();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		desktopPane_right.setBackground(Color.GRAY);
		desktopPane_right.setBounds(200, 0, frame.getBounds().width, frame.getBounds().height);
		frame.getContentPane().add(desktopPane_right);

		desktopPane_left.setBackground(Color.LIGHT_GRAY);
		desktopPane_left.setBounds(0, 0, 200, frame.getBounds().height);
		frame.getContentPane().add(desktopPane_left);

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				 if (e.getSource() == frame) {

				        desktopPane_right.setBounds(200, 0, frame.getBounds().width, frame.getBounds().height);
					 	desktopPane_left.setBounds(0, 0, 200, frame.getBounds().height);
			}
		}});
		

		//functie
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds((desktopPane_left.getBounds().width / 2)-30, 22, 120, 30);

		String[] choiceList = {"Car","Traffic Light","Road Sign","Building","+ADD Option"};
		JComboBox chooseFromList = new JComboBox(choiceList);
		chooseFromList.setSelectedIndex(-1);
		chooseFromList.setBounds((desktopPane_left.getBounds().width / 2)-30, 100, 120, 30);

		desktopPane_left.add(btnAdd);
		desktopPane_left.add(chooseFromList);

		//functie
		try {
			Image cropImage = ImageIO.read(new File("./src/images/test.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			ImageIcon cropIcon = new ImageIcon(cropImage);

			Image addImage = ImageIO.read(new File("./src/images/plusSign.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon addIcon = new ImageIcon(addImage);

			JLabel cropLabel = new JLabel();
			cropLabel.setBounds((desktopPane_left.getBounds().width / 2) - (120 / 2) - 25, 90, 50, 50);
			cropLabel.setIcon(cropIcon);

			JLabel addLabel = new JLabel();
			addLabel.setBounds((desktopPane_left.getBounds().width / 2) - (120 / 2) - 17, 12, 50, 50);
			addLabel.setIcon(addIcon);

			desktopPane_left.add(cropLabel);
			desktopPane_left.add(addLabel);
		}
		catch(Exception e){}
		frame.revalidate();

	}
}
