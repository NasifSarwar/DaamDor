import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.Toolkit;
public class Signup {

	JFrame signupFrame;
	private JTextField nametextField;
	private JTextField phonetextField;
	private JTextField passtextField;
	private JTextField cpasstextField;
	PreparedStatement pst;
	private JComboBox areacomboBox;
	
	Connection con = DB.dbconnect();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.signupFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Signup() {
		initialize();
	}


	private void initialize() {
		signupFrame = new JFrame();
		signupFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		signupFrame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		signupFrame.setBounds(100, 100, 1080, 720);
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Create New Account");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("Area");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Confirm Password");
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 22));
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		
		phonetextField = new JTextField();
		phonetextField.setColumns(10);
		
		passtextField = new JTextField();
		passtextField.setColumns(10);
		
		cpasstextField = new JTextField();
		cpasstextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Signup as Buyer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Signing up as a buyer.
				
				String name = nametextField.getText();
				String phone = phonetextField.getText();
				String area = areacomboBox.getSelectedItem().toString();
				String pass = passtextField.getText();
				String cpass = cpasstextField.getText();
				
				if(name.isEmpty()||phone.isEmpty()||pass.isEmpty()||cpass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
					return;
				}
				if(!pass.equals(cpass)) {
					JOptionPane.showMessageDialog(null, "Confirm Password dews not match");
					return;
				}

				
				try {
					String phonechk = phonetextField.getText();
					
					//Query 3(to check if the phone number exists)
					
					pst = con.prepareStatement("select * from customerinfo where phone=? ");
					pst.setString(1, phonechk);
					
					ResultSet r = pst.executeQuery();
				
				if(r.next()) {
					

						
						JOptionPane.showMessageDialog(null, "Phone number already exixt");
				
				}
				else {
					
					//Query 4(to signup a new buyer)
					
					pst = con.prepareStatement("insert into customerInfo (name,phone,area,password) values (?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, phone);
					pst.setString(3, area);
					pst.setString(4, pass);
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(null, "SignUp Complete, Press OK for Login");
					nametextField.setText("");
					phonetextField.setText("");
					
					passtextField.setText("");
					cpasstextField.setText("");
					welcome wlc= new welcome();
					wlc.welcomeFrame.setVisible(true);
					signupFrame.dispose();
					
				}
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnSignupAsRetailer = new JButton("Signup as Retailer");
		btnSignupAsRetailer.addActionListener(new ActionListener() {
			
			//signing up as a retailer.
			
			public void actionPerformed(ActionEvent e) {
				String name = nametextField.getText();
				String phone = phonetextField.getText();
				String area = areacomboBox.getSelectedItem().toString();
				String pass = passtextField.getText();
				String cpass = cpasstextField.getText();
				
				if(name.isEmpty()||phone.isEmpty()||pass.isEmpty()||cpass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
					return;
				}
				if(!pass.equals(cpass)) {
					JOptionPane.showMessageDialog(null, "Confirm Password dews not match");
					return;
				}

				
				try {
					String phonechk = phonetextField.getText();
					
					//Query 5(to check if the phone number exists)
					
					PreparedStatement pst = con.prepareStatement("select * from retailerinfo where phone=?");
					pst.setString(1, phonechk);
					
					ResultSet r = pst.executeQuery();
				
				if(r.next()) {
					

						
						JOptionPane.showMessageDialog(null, "Phone number already exixt");

				}
				else {
					
					//Query 6(to signup a new retailer)

					
					pst = con.prepareStatement("insert into retailerInfo (name,phone,area,password) values (?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, phone);
					pst.setString(3, area);
					pst.setString(4, pass);
					pst.executeUpdate();
					
					
					JOptionPane.showMessageDialog(null, "SignUp Complete, Press OK for login");
					nametextField.setText("");
					phonetextField.setText("");
					
					passtextField.setText("");
					cpasstextField.setText("");
					welcome wlc= new welcome();
					wlc.welcomeFrame.setVisible(true);
					signupFrame.dispose();
					
				}
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
				
			}
		});
		btnSignupAsRetailer.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wlc= new welcome();
				wlc.welcomeFrame.setVisible(true);
				signupFrame.dispose();
			}
		});
		btnCancel.setBackground(new Color(255, 51, 51));
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 18));
		String[] area= {"Mohammadpur","Shyamoli","Mirpur","Dhanmondi","Tejgaon","Motijheel","Gulshan","Jatra Bari","Mohakhali","Banani"};

		 areacomboBox = new JComboBox(area);
		GroupLayout groupLayout = new GroupLayout(signupFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
							.addGap(428))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(btnSignupAsRetailer))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_4_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
									.addGap(154)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cpasstextField)
										.addComponent(nametextField)
										.addComponent(passtextField)
										.addComponent(phonetextField)
										.addComponent(areacomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(450))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(295)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(594, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(lblNewLabel)
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_4_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(phonetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(areacomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cpasstextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSignupAsRetailer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		signupFrame.getContentPane().setLayout(groupLayout);
	}
}
