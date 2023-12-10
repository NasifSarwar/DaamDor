import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class BuyerDashboard {

	 JFrame dashboardframe;
	 Connection con = DB.dbconnect();
	 ResultSet rs;
	 PreparedStatement ps;
	 JLabel totalproductlblNewLabel;
	 public void total() {
		 try {
			 
			//Query 10 (Count of all the products of a loged in customer)

			 
		 ps=con.prepareStatement("select count(customerProductID)  from customerProduct where customerID=?");
			ps.setInt(1,BuyerProduct.customerforeignkey);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int total=rs.getInt("count(customerProductID)");
				totalproductlblNewLabel.setText(String.valueOf(total));

			}
		 }
		 catch(Exception e1) {
				e1.printStackTrace();

			 
		 }
	 }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerDashboard window = new BuyerDashboard();
					window.dashboardframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuyerDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dashboardframe = new JFrame();
		dashboardframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		dashboardframe.getContentPane().setBackground(UIManager.getColor("Button.background"));
		dashboardframe.setBounds(100, 100, 1080, 720);
		dashboardframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(996, 0, 118, 726);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1194, 81);
		panel_1.setBackground(new Color(147, 112, 219));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 82, 177, 600);
		panel_2.setBackground(new Color(0, 128, 128));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 79, 82);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		panel_1.add(lblNewLabel_1);
		dashboardframe.getContentPane().setLayout(null);
		dashboardframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyerProduct bp = new BuyerProduct();
				bp.productframe.setVisible(true);
				dashboardframe.dispose();
			}
		});
		btnProducts.setForeground(new Color(250, 240, 230));
		btnProducts.setFont(new Font("Arial", Font.BOLD, 20));
		btnProducts.setBackground(new Color(0, 128, 128));
		btnProducts.setBounds(0, 137, 177, 56);
		panel_2.add(btnProducts);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wlc= new welcome();
				wlc.welcomeFrame.setVisible(true);
				dashboardframe.dispose();
				
			}
		});
		btnSignout.setForeground(new Color(250, 240, 230));
		btnSignout.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignout.setBackground(new Color(0, 128, 128));
		btnSignout.setBounds(0, 191, 177, 56);
		panel_2.add(btnSignout);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyerProfile bf = new BuyerProfile();
				bf.profileframe.setVisible(true);
				dashboardframe.dispose();
			}
		});
		btnNewButton.setForeground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(0, 83, 177, 56);
		panel_2.add(btnNewButton);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setForeground(new Color(250, 240, 230));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		btnDashboard.setBackground(new Color(30, 144, 255));
		btnDashboard.setBounds(0, 28, 177, 56);
		panel_2.add(btnDashboard);
		dashboardframe.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buyer Dashboard");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 207, 43);
		panel_1.add(lblNewLabel_2);
		dashboardframe.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(267, 164, 307, 176);
		dashboardframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 307, 46);
		panel_3.setBackground(new Color(255, 127, 80));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3.setBounds(105, 11, 105, 24);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 130, 307, 46);
		panel_3_1.setBackground(new Color(255, 127, 80));
		panel.add(panel_3_1);
		
		JLabel welcomelblNewLabel = new JLabel("");
		welcomelblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		welcomelblNewLabel.setBounds(26, 67, 252, 52);
		panel.add(welcomelblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(65, 105, 225));
		panel_4.setBounds(652, 164, 307, 176);
		dashboardframe.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(0, 0, 307, 46);
		panel_3_2.setBackground(new Color(30, 144, 255));
		panel_4.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Total Products");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_1.setBounds(74, 11, 171, 24);
		panel_3_2.add(lblNewLabel_3_1);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBounds(0, 130, 307, 46);
		panel_3_2_1.setBackground(new Color(30, 144, 255));
		panel_4.add(panel_3_2_1);
		
		totalproductlblNewLabel = new JLabel("");
		totalproductlblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		totalproductlblNewLabel.setBounds(122, 67, 124, 52);
		panel_4.add(totalproductlblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(186, 85, 211));
		panel_5.setBounds(267, 380, 307, 176);
		dashboardframe.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(0, 0, 307, 46);
		panel_3_3.setBackground(new Color(238, 130, 238));
		panel_5.add(panel_3_3);
		panel_3_3.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("Total Quantity");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_2.setBounds(74, 11, 165, 24);
		panel_3_3.add(lblNewLabel_3_2);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBounds(0, 130, 307, 46);
		panel_3_3_1.setBackground(new Color(238, 130, 238));
		panel_5.add(panel_3_3_1);
		
		JLabel totalquantitylblNewLabel = new JLabel("");
		totalquantitylblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		totalquantitylblNewLabel.setBounds(117, 67, 111, 52);
		panel_5.add(totalquantitylblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 255, 153));
		panel_6.setBounds(652, 380, 307, 176);
		dashboardframe.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBounds(0, 0, 307, 46);
		panel_3_4.setBackground(new Color(144, 238, 144));
		panel_6.add(panel_3_4);
		panel_3_4.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("Area");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_3.setBounds(124, 11, 58, 24);
		panel_3_4.add(lblNewLabel_3_3);
		
		JPanel panel_3_4_1 = new JPanel();
		panel_3_4_1.setBounds(0, 130, 307, 46);
		panel_3_4_1.setBackground(new Color(144, 238, 144));
		panel_6.add(panel_3_4_1);
		
		JLabel arealblNewLabel = new JLabel("");
		arealblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		arealblNewLabel.setBounds(79, 67, 218, 52);
		panel_6.add(arealblNewLabel);
		
		try {
			
			//Query 11 (taking customer name and area from customerinfo table)	 

			
			ps=con.prepareStatement("select * from customerInfo where phone=?");
			ps.setString(1,welcome.customerLoginPhn);
			rs = ps.executeQuery();
			if(rs.next()) {
				welcomelblNewLabel.setText(rs.getString("name"));
				
			
				arealblNewLabel.setText(rs.getString("area"));
				
				
			}
		total();

		//Query 12( (Sum of all the product quantity of a loged in customer)
	
		
				ps=con.prepareStatement("select sum(quantity)  from customerProduct where customerID=?");
				ps.setInt(1,BuyerProduct.customerforeignkey);
				rs=ps.executeQuery();
				while(rs.next()) {
					int total1=rs.getInt("sum(quantity)");
					totalquantitylblNewLabel.setText(String.valueOf(total1));

			}
		}
					
		catch(Exception e1) {
			e1.printStackTrace();
		}
			
		
	}
}
