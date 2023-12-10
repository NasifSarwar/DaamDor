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

import com.mysql.cj.protocol.Resultset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class BuyerProfile {
	
	
	
	

	 JFrame profileframe;
	 private JTextField buyerIdtextField;
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
					BuyerProfile window = new BuyerProfile();
					window.profileframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuyerProfile() {
		initialize();
	}


	private void initialize() {
		profileframe = new JFrame();
		profileframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		profileframe.getContentPane().setBackground(UIManager.getColor("Button.background"));
		profileframe.setBounds(100, 100, 1080, 720);
		profileframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		profileframe.getContentPane().setLayout(null);
		profileframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyerProduct bf = new BuyerProduct();
				bf.productframe.setVisible(true);
				profileframe.dispose();
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
				welcome wlc = new welcome();
				wlc.welcomeFrame.setVisible(true);
				profileframe.dispose();
			}
		});
		btnSignout.setForeground(new Color(250, 240, 230));
		btnSignout.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignout.setBackground(new Color(0, 128, 128));
		btnSignout.setBounds(0, 191, 177, 56);
		panel_2.add(btnSignout);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setForeground(new Color(250, 240, 230));
		btnProfile.setFont(new Font("Arial", Font.BOLD, 20));
		btnProfile.setBackground(new Color(30, 144, 255));
		btnProfile.setBounds(0, 82, 177, 56);
		panel_2.add(btnProfile);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyerDashboard db = new BuyerDashboard();
				db.dashboardframe.setVisible(true);
				profileframe.dispose();
			}
		});
		btnDashboard.setForeground(new Color(250, 240, 230));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		btnDashboard.setBackground(new Color(0, 128, 128));
		btnDashboard.setBounds(0, 27, 177, 56);
		panel_2.add(btnDashboard);
		profileframe.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buyer Profile");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 207, 43);
		panel_1.add(lblNewLabel_2);
		profileframe.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(204, 102, 630, 373);
		profileframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Buyer ID");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel_3.setBounds(43, 49, 107, 34);
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
		
		buyerIdtextField = new JTextField();
		buyerIdtextField.setEditable(false);
		buyerIdtextField.setBounds(332, 49, 222, 31);
		panel.add(buyerIdtextField);
		buyerIdtextField.setColumns(10);
		
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
			
			//Query 14( Show customer info from customerinfo table)

			ps=con.prepareStatement("select * from customerInfo where phone=?");
			ps.setString(1,welcome.customerLoginPhn);
			rs = ps.executeQuery();
			if(rs.next()) {
				buyerIdtextField.setText(rs.getString("customerID"));
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

