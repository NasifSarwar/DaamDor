

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
import java.awt.Toolkit;

public class RetailerDashboard {

	JFrame RetailerDashboardFrame;
	 Connection con = DB.dbconnect();
	 ResultSet rs;
	 PreparedStatement ps;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailerDashboard window = new RetailerDashboard();
					window.RetailerDashboardFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RetailerDashboard() {
		initialize();
	}

	
	private void initialize() {
		RetailerDashboardFrame = new JFrame();
		RetailerDashboardFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		RetailerDashboardFrame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		RetailerDashboardFrame.setBounds(100, 100, 1080, 720);
		RetailerDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		RetailerDashboardFrame.getContentPane().setLayout(null);
		RetailerDashboardFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnProducts = new JButton("My Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyProducts mprdt= new MyProducts();
				mprdt.MyProductFrame.setVisible(true);
				RetailerDashboardFrame.dispose();
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
				RetailerDashboardFrame.dispose();
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
				RetailerProfile rtpr= new RetailerProfile();
				rtpr.RetailerProfileFrame.setVisible(true);
				RetailerDashboardFrame.dispose();
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
		RetailerDashboardFrame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retailer Dashboard");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 232, 43);
		panel_1.add(lblNewLabel_2);
		RetailerDashboardFrame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(258, 161, 307, 176);
		RetailerDashboardFrame.getContentPane().add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 127, 80));
		panel_3.setBounds(0, 0, 307, 46);
		panel.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3.setBounds(105, 11, 105, 24);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 127, 80));
		panel_3_1.setBounds(0, 130, 307, 46);
		panel.add(panel_3_1);
		
		JLabel welcomelblNewLabel = new JLabel("");
		welcomelblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		welcomelblNewLabel.setBounds(29, 67, 268, 52);
		panel.add(welcomelblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(65, 105, 225));
		panel_4.setBounds(643, 161, 307, 176);
		RetailerDashboardFrame.getContentPane().add(panel_4);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(30, 144, 255));
		panel_3_2.setBounds(0, 0, 307, 46);
		panel_4.add(panel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Total Products");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_1.setBounds(74, 11, 171, 24);
		panel_3_2.add(lblNewLabel_3_1);
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setBackground(new Color(30, 144, 255));
		panel_3_2_1.setBounds(0, 130, 307, 46);
		panel_4.add(panel_3_2_1);
		
		JLabel totalProductlblNewLabel_1 = new JLabel("");
		totalProductlblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		totalProductlblNewLabel_1.setBounds(29, 67, 268, 52);
		panel_4.add(totalProductlblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(186, 85, 211));
		panel_5.setBounds(258, 377, 307, 176);
		RetailerDashboardFrame.getContentPane().add(panel_5);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBackground(new Color(238, 130, 238));
		panel_3_3.setBounds(0, 0, 307, 46);
		panel_5.add(panel_3_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("Total Quantity");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_2.setBounds(74, 11, 165, 24);
		panel_3_3.add(lblNewLabel_3_2);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBackground(new Color(238, 130, 238));
		panel_3_3_1.setBounds(0, 130, 307, 46);
		panel_5.add(panel_3_3_1);
		
		JLabel totalQuantitylblNewLabel_2 = new JLabel("");
		totalQuantitylblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		totalQuantitylblNewLabel_2.setBounds(29, 67, 268, 52);
		panel_5.add(totalQuantitylblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(0, 255, 153));
		panel_6.setBounds(643, 377, 307, 176);
		RetailerDashboardFrame.getContentPane().add(panel_6);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setLayout(null);
		panel_3_4.setBackground(new Color(144, 238, 144));
		panel_3_4.setBounds(0, 0, 307, 46);
		panel_6.add(panel_3_4);
		
		JLabel lblNewLabel_3_3 = new JLabel("Area");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_3.setBounds(124, 11, 58, 24);
		panel_3_4.add(lblNewLabel_3_3);
		
		JPanel panel_3_4_1 = new JPanel();
		panel_3_4_1.setBackground(new Color(144, 238, 144));
		panel_3_4_1.setBounds(0, 130, 307, 46);
		panel_6.add(panel_3_4_1);
		
		JLabel arealblNewLabel_3 = new JLabel("");
		arealblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		arealblNewLabel_3.setBounds(29, 67, 268, 52);
		panel_6.add(arealblNewLabel_3);
		try {
			
			//Query 7 (taking retailer name and area from retailerinfo table)
			
			ps=con.prepareStatement("select * from retailerInfo where phone=?");
			ps.setString(1,welcome.retailerLoginPhn);
			rs = ps.executeQuery();
			if(rs.next()) {
				welcomelblNewLabel.setText(rs.getString("name"));
				
			
				arealblNewLabel_3.setText(rs.getString("area"));
				
				
			}
			 
			//Query 8 (Count of all the products of a loged in retailer)
			
			 ps=con.prepareStatement("select count(retailerProductID)  from retailerProduct where retailerID=?");
				ps.setInt(1,MyProducts.retailerforeignkey);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					//saving total products in a variable
					int total=rs.getInt("count(retailerProductID)");
					totalProductlblNewLabel_1.setText(String.valueOf(total));

				}
				
				//Query 9( (Sum of all the product quantity of a loged in retailer)
				
				ps=con.prepareStatement("select sum(quantity)  from retailerProduct where retailerID=?");
				ps.setInt(1,MyProducts.retailerforeignkey);
				rs=ps.executeQuery();
				while(rs.next()) {					
					//saving total quantity in a variable
					int total1=rs.getInt("sum(quantity)");
					totalQuantitylblNewLabel_2.setText(String.valueOf(total1));

			}
		
					}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		

		
	}
}
