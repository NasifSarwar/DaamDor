

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
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class RetailerProfile {

	 JFrame RetailerProfileFrame;
	 private JTextField retailerIdtextField;
	 private JTextField nametextField;
	 private JTextField phonetextField;
	 private JTextField areatextField;
	 Connection con = DB.dbconnect();
	 ResultSet rs;
	 PreparedStatement ps;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailerProfile window = new RetailerProfile();
					window.RetailerProfileFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RetailerProfile() {
		initialize();
	}

	private void initialize() {
		RetailerProfileFrame = new JFrame();
		RetailerProfileFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		RetailerProfileFrame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		RetailerProfileFrame.setBounds(100, 100, 1080, 720);
		RetailerProfileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		RetailerProfileFrame.getContentPane().setLayout(null);
		RetailerProfileFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnProducts = new JButton("My Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyProducts mpds= new MyProducts();
				mpds.MyProductFrame.setVisible(true);
				RetailerProfileFrame.dispose();
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
				RetailerProfileFrame.dispose();
			}
		});
		btnSignout.setForeground(new Color(250, 240, 230));
		btnSignout.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignout.setBackground(new Color(0, 128, 128));
		btnSignout.setBounds(0, 191, 177, 56);
		panel_2.add(btnSignout);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setForeground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(0, 83, 177, 56);
		panel_2.add(btnNewButton);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerDashboard rtdb= new RetailerDashboard();
				rtdb.RetailerDashboardFrame.setVisible(true);
				RetailerProfileFrame.dispose();
			}
		});
		btnDashboard.setForeground(new Color(250, 240, 230));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		btnDashboard.setBackground(new Color(0, 128, 128));
		btnDashboard.setBounds(0, 28, 177, 56);
		panel_2.add(btnDashboard);
		RetailerProfileFrame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retailer Profile");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 232, 43);
		panel_1.add(lblNewLabel_2);
		RetailerProfileFrame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(198, 103, 630, 373);
		RetailerProfileFrame.getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("Retailer ID");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3.setBounds(43, 49, 125, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_1.setBounds(43, 115, 74, 34);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Phone");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_2.setBounds(43, 179, 74, 34);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Area");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3_3.setBounds(43, 244, 74, 34);
		panel.add(lblNewLabel_3_3);
		
		retailerIdtextField = new JTextField();
		retailerIdtextField.setEditable(false);
		retailerIdtextField.setColumns(10);
		retailerIdtextField.setBounds(332, 49, 222, 31);
		panel.add(retailerIdtextField);
		
		nametextField = new JTextField();
		nametextField.setEditable(false);
		nametextField.setColumns(10);
		nametextField.setBounds(332, 118, 222, 31);
		panel.add(nametextField);
		
		phonetextField = new JTextField();
		phonetextField.setEditable(false);
		phonetextField.setColumns(10);
		phonetextField.setBounds(332, 182, 222, 31);
		panel.add(phonetextField);
		
		areatextField = new JTextField();
		areatextField.setEditable(false);
		areatextField.setColumns(10);
		areatextField.setBounds(332, 247, 222, 31);
		panel.add(areatextField);
		try {
			
			//Query 13( Show retailer info from retailerinfo table)

			
			ps=con.prepareStatement("select * from retailerInfo where phone=?");
			ps.setString(1,welcome.retailerLoginPhn);
			rs = ps.executeQuery();
			if(rs.next()) {
				retailerIdtextField.setText(rs.getString("retailerID"));
				nametextField.setText(rs.getString("name"));
				phonetextField.setText(rs.getString("phone"));
				areatextField.setText(rs.getString("area"));
				
				
			}
			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
