import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;


public class welcome {
	
	public static String retailerLoginPhn;
	public static String customerLoginPhn;

	 JFrame welcomeFrame;
	private JTextField phonetextField;
	private JPasswordField passwordField;

	Connection con = DB.dbconnect();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome window = new welcome();
					window.welcomeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public welcome() {
		initialize();
	}

	private void initialize() {
		welcomeFrame = new JFrame();
		welcomeFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		welcomeFrame.getContentPane().setBackground(Color.WHITE);
		welcomeFrame.setBounds(100, 100, 1080, 720);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 625, 704);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DCL\\Downloads\\Logo.jpeg"));
		
		phonetextField = new JTextField();
		phonetextField.setBounds(795, 317, 205, 20);
		phonetextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setBounds(669, 307, 94, 35);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(795, 402, 205, 20);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(669, 386, 94, 46);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("Login as Buyer");
		btnNewButton.setBounds(669, 486, 151, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//We are matching login information with the database(buyer)
					
					String phone = phonetextField.getText();
					customerLoginPhn=phone;
					String pass = String.valueOf(passwordField.getPassword());
					if(phone.isEmpty()||phone.isEmpty()||pass.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter all fields");
						return;
					}
					//Query 1(to match login info from customerinfo table)
					PreparedStatement pst = con.prepareStatement("select * from customerinfo where phone=? and password=?");
					pst.setString(1, phone);
					pst.setString(2, pass);
					ResultSet r = pst.executeQuery();

					if(r.next()) {
						BuyerProduct.customerforeignkey=r.getInt("customerID");

						BuyerDashboard bd = new BuyerDashboard();
						bd.dashboardframe.setVisible(true);
						welcomeFrame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect phone or password");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnSignup = new JButton("Create Account");
		btnSignup.setBounds(735, 547, 219, 33);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Shifting to signup page from login page.
				Signup si = new Signup();
				si.signupFrame.setVisible(true);
				welcomeFrame.dispose();
	
			}

		
		});
		btnSignup.setFont(new Font("Arial", Font.BOLD, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(774, 606, 1, 2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(735, 530, 210, 6);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Daam Dor");
		lblNewLabel_2.setBounds(683, 133, 298, 37);
		lblNewLabel_2.setForeground(new Color(102, 102, 204));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		welcomeFrame.getContentPane().setLayout(null);
		welcomeFrame.getContentPane().add(separator);
		welcomeFrame.getContentPane().add(separator_1);
		welcomeFrame.getContentPane().add(lblNewLabel_1);
		welcomeFrame.getContentPane().add(lblNewLabel_1_1);
		welcomeFrame.getContentPane().add(phonetextField);
		welcomeFrame.getContentPane().add(passwordField);
		welcomeFrame.getContentPane().add(btnNewButton);
		welcomeFrame.getContentPane().add(btnSignup);
		welcomeFrame.getContentPane().add(lblNewLabel_2);
		welcomeFrame.getContentPane().add(lblNewLabel);
		
		JButton btnLoginRetailar = new JButton("Login as Retailar");
		btnLoginRetailar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					//We are matching login information with the database(retailer)
					String phone = phonetextField.getText();
					retailerLoginPhn=phone;
					
					String pass = String.valueOf(passwordField.getPassword());
					if(phone.isEmpty()||phone.isEmpty()||pass.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter all fields");
						return;
					}
					//Query 2(to match login info from retailerinfo table)
					PreparedStatement pst = con.prepareStatement("select * from retailerinfo where phone=? and password=?");
					pst.setString(1, phone);
					pst.setString(2, pass);
					ResultSet r = pst.executeQuery();
					if(r.next()) {
						MyProducts.retailerforeignkey=r.getInt("retailerID");

						RetailerDashboard bd = new RetailerDashboard();
						bd.RetailerDashboardFrame.setVisible(true);
						welcomeFrame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect phone or password");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoginRetailar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLoginRetailar.setBounds(835, 486, 165, 33);
		welcomeFrame.getContentPane().add(btnLoginRetailar);
	}
}
