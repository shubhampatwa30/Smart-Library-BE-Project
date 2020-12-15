package test5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class gui6 {

	static public JFrame frame;
	//static public JTextField txtWelcomeToSmart;
	//static public JTextField txtPressTheIssue;
	//static	public JTextField textField;
	static public JPanel panel,panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9;//= new JPanel();
	static JLabel lblWelcomeToSmart;
	static JButton btnClickTo_1,btnClickTo,btnClickTo_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui6 window = new gui6();
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
	public gui6() {
		initialize();

}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(54, 33, 89));
		panel.setBounds(0, 0, 386, 1033);
		frame.getContentPane().add(panel);
		panel.setLayout(null);



		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(102, 0, 153));
		panel_1.setBounds(384, 0, 1537, 1103);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);



		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 153));
		panel_2.setBackground(new Color(122, 72, 221));
		panel_2.setBounds(0, 141, 1670, 364);
		panel_1.add(panel_2);
		panel_2.setLayout(null);





		lblWelcomeToSmart = new JLabel("Welcome to Smart Library.\r\nPlease proceed with the options on the left.");
		lblWelcomeToSmart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblWelcomeToSmart.setForeground(new Color(255, 255, 255));
		lblWelcomeToSmart.setBounds(59, 63, 724, 93);
		panel_2.add(lblWelcomeToSmart);


		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				issuegui();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(85, 65, 118));
		btnNewButton.setBounds(0, 232, 386, 45);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Return Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				returngui();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(85, 65, 118));
		btnNewButton_1.setBounds(0, 306, 386, 45);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Coming Soon");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(85, 65, 118));
		btnNewButton_2.setBounds(0, 379, 386, 45);
		panel.add(btnNewButton_2);

		JButton btnHomepage = new JButton("HomePage");
		btnHomepage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHomepage.setBackground(new Color(85, 65, 118));
		btnHomepage.setForeground(new Color(255, 255, 255));
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				homepage();

			}
		});
		btnHomepage.setBounds(79, 163, 233, 45);
		panel.add(btnHomepage);
	}
	public static void homepage() {
		panel_1.removeAll();
		panel_1.repaint();
		panel_1.revalidate();


		panel_1.add(panel_2);
		panel_2.removeAll();
		panel_2.repaint();
		panel_2.revalidate();

		JLabel lblWelcomeToSmart1 = new JLabel("Welcome to Smart Library.\r\nPlease proceed with the options on the left.");
		lblWelcomeToSmart1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblWelcomeToSmart1.setForeground(new Color(255, 255, 255));
		lblWelcomeToSmart1.setBounds(59, 63, 724, 93);
		panel_2.add(lblWelcomeToSmart1);

	}


	public  static void issuegui()
	{panel_1.removeAll();
	panel_1.repaint();
	panel_1.revalidate();


	panel_1.add(panel_2);
	panel_2.removeAll();
	panel_2.repaint();
	panel_2.revalidate();





	JLabel lblScan = new JLabel("Follow the steps: Click on the button and swipe the RFID Card.");
	lblScan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblScan.setForeground(new Color(255, 255, 255));
	lblScan.setBounds(12, 13, 724, 79);
	panel_2.add(lblScan);

	btnClickTo = new JButton("Click to scan your ID Card.");
	btnClickTo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JavaArduinoComm.issuemain();
			JavaArduinoComm.issue();

		}
	});
	btnClickTo.setForeground(Color.WHITE);
	btnClickTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnClickTo.setBackground(new Color(85, 65, 118));
	btnClickTo.setBounds(207, 129, 335, 50);
	panel_2.add(btnClickTo);








	}

	public static void issuegui1(String name) {

		panel_1.removeAll();
		panel_1.repaint();
		panel_1.revalidate();


		panel_1.add(panel_2);
		panel_2.removeAll();
		panel_2.repaint();
		panel_2.revalidate();
		JLabel lblCardScanSuccessful = new JLabel("Card Scan successful.Welcome "+name+".");
		lblCardScanSuccessful.setForeground(new Color(255, 255, 255));
		lblCardScanSuccessful.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblCardScanSuccessful.setBounds(29, 513, 584, 59);
		panel_1.add(lblCardScanSuccessful);

		JLabel lblSinceYouHave = new JLabel("Since you have issued more than 3 books, you cannot issue books anymore.");
		lblSinceYouHave.setForeground(Color.WHITE);
		lblSinceYouHave.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblSinceYouHave.setBounds(29, 578, 728, 63);
		panel_1.add(lblSinceYouHave);

		JLabel lblCardDisapproved = new JLabel("Card disapproved.");
		lblCardDisapproved.setForeground(Color.WHITE);
		lblCardDisapproved.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblCardDisapproved.setBounds(29, 643, 341, 59);
		panel_1.add(lblCardDisapproved);




		JLabel lblWelcomeToSmart1 = new JLabel("Card Disapproved. Issue failed.");
		lblWelcomeToSmart1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblWelcomeToSmart1.setForeground(new Color(255, 255, 255));
		lblWelcomeToSmart1.setBounds(27, 65, 593, 93);
		panel_2.add(lblWelcomeToSmart1);






	}
	public static void issuegui2(String name) {

		panel_1.removeAll();
		panel_1.repaint();
		panel_1.revalidate();


		panel_1.add(panel_2);
		panel_2.removeAll();
		panel_2.repaint();
		panel_2.revalidate();



		JLabel CardScan = new JLabel("Card Scan successful. Welcome "+name+".");
		CardScan.setForeground(new Color(255, 255, 255));
		CardScan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		CardScan.setBounds(27, 532, 477, 52);
		panel_1.add(CardScan);

		JLabel SinceYouHave = new JLabel("Please scan the book.");
		SinceYouHave.setForeground(Color.WHITE);
		SinceYouHave.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		SinceYouHave.setBounds(27, 584, 699, 52);
		panel_1.add(SinceYouHave);


		JLabel lblScan = new JLabel("Follow the step:");
		lblScan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
		lblScan.setForeground(new Color(255, 255, 255));
		lblScan.setBounds(12, 13, 593, 66);
		panel_2.add(lblScan);
		//panel_2.remove(btnClickTo);


		btnClickTo_1 = new JButton("Click to scan the book.");
		btnClickTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JavaArduinoComm.bookconn();
				JavaArduinoComm.bookissue();
			
				JavaArduinoComm.gotoguiissue3();


			}
		});
		btnClickTo_1.setForeground(Color.WHITE);
		btnClickTo_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClickTo_1.setBackground(new Color(85, 65, 118));
		btnClickTo_1.setBounds(259, 137, 295, 50);
		panel_2.add(btnClickTo_1);





	}
	public static void issuegui3(String doer) {
		panel_1.removeAll();
		panel_1.repaint();
		panel_1.revalidate();


		panel_1.add(panel_2);
		panel_2.removeAll();
		panel_2.repaint();
		panel_2.revalidate();
		JLabel lbliss = new JLabel("Book issued successfully.");
		lbliss.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lbliss.setForeground(new Color(255, 255, 255));
		lbliss.setBounds(12, 13, 593, 65);
		panel_2.add(lbliss);

		JLabel lblPleaseReturnIt = new JLabel("Please return it on or before "+doer);
		lblPleaseReturnIt.setForeground(Color.WHITE);
		lblPleaseReturnIt.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblPleaseReturnIt.setBounds(12, 91, 593, 65);
		panel_2.add(lblPleaseReturnIt);
		
		




	}

	public static void returngui()
	{panel_1.removeAll();
	panel_1.repaint();
	panel_1.revalidate();


	panel_1.add(panel_2);
	panel_2.removeAll();
	panel_2.repaint();
	panel_2.revalidate();



	JLabel lblretur = new JLabel("Follow the steps: Click on the button and swipe the book.");
	lblretur.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblretur.setForeground(new Color(255, 255, 255));
	lblretur.setBounds(12, 13, 593, 66);
	panel_2.add(lblretur);

	btnClickTo_2 = new JButton("Click to Scan the Book RFID.");
	btnClickTo_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JavaArduinoComm.returnmain();
			JavaArduinoComm.returnbook();

		}
	});
	btnClickTo_2.setForeground(Color.WHITE);
	btnClickTo_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnClickTo_2.setBackground(new Color(85, 65, 118));
	btnClickTo_2.setBounds(211, 131, 327, 52);
	panel_2.add(btnClickTo_2);



	}
	public static void returngui1(String name,long fine)
	{panel_1.removeAll();
	panel_1.repaint();
	panel_1.revalidate();


	panel_1.add(panel_2);
	panel_2.removeAll();
	panel_2.repaint();
	panel_2.revalidate();



	JLabel lblretsuc = new JLabel("Book '"+name+"' returned successfully.");
	lblretsuc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblretsuc.setForeground(new Color(255, 255, 255));
	lblretsuc.setBounds(12, 13, 593, 65);
	panel_2.add(lblretsuc);

	JLabel lblyourfine = new JLabel("Please pay the fine amounting to rupees :"+fine);
	lblyourfine.setForeground(Color.WHITE);
	lblyourfine.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblyourfine.setBounds(12, 91, 593, 65);
	panel_2.add(lblyourfine);

	}

	public static void returngui2(String name)
	{panel_1.removeAll();
	panel_1.repaint();
	panel_1.revalidate();


	panel_1.add(panel_2);
	panel_2.removeAll();
	panel_2.repaint();
	panel_2.revalidate();



	JLabel lblretsuc = new JLabel("Book '"+name+"' returned successfully.");
	lblretsuc.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblretsuc.setForeground(new Color(255, 255, 255));
	lblretsuc.setBounds(12, 13, 593, 65);
	panel_2.add(lblretsuc);

	JLabel lblyourfine = new JLabel("No fine incurred");
	lblyourfine.setForeground(Color.WHITE);
	lblyourfine.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	lblyourfine.setBounds(12, 91, 593, 65);
	panel_2.add(lblyourfine);


	}
}
