

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class MyProducts {

	JFrame MyProductFrame;
	private JTextField pricetextField;
	private JTextField quantitytextField;
	 DefaultTableModel model;
	 DefaultTableModel model1;

	JComboBox areacomboBox;
	 Connection con = DB.dbconnect();
	 ResultSet rs;
	 PreparedStatement ps;
	 String whichTable;
	 public static  int retailerforeignkey;
	 private JTable table;
	 private JTable table_1;
		public int productID(String productname) {
			int productid=0;
			String[] product= {"Potato","Tomato","Chilli","Onion","Carrot","Capsicum","Cucumber","Radish","Ginger","Pumpkin"};

			for(int i=0;i<10;i++) {
			if(productname == product[i]) { 
			productid=i+1 ;
			break;
			}
			}
			return productid;
	
	}




	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProducts window = new MyProducts();
					window.MyProductFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MyProducts() {
		initialize();
	}

	private void initialize() {
		MyProductFrame = new JFrame();
		MyProductFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		MyProductFrame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		MyProductFrame.setBounds(100, 100, 1080, 720);
		MyProductFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 386, 390, 302);
		MyProductFrame.getContentPane().add(scrollPane);
		//table 2
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(589, 163, 465, 375);
		MyProductFrame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		// Show as table
		
		String[] show_as= {"Average price of products in the city","Average price with quantity (Area wise)","Average price and Maximum quantity (Area wise)"};
		JComboBox showAscomboBox = new JComboBox(show_as);
		showAscomboBox.setBounds(716, 130, 310, 22);
		MyProductFrame.getContentPane().add(showAscomboBox);
		
		
		
		try {
			
			//Query 15 ( show Average price of products in the city )
			
			ps=con.prepareStatement("SELECT `name` AS Product, round(AVG(`price`) ,2) AS `Average Price`,SUM(`quantity`) AS `Total Quantity`  FROM `retailerproduct` GROUP BY `name` ORDER BY `quantity` DESC;");
			
			rs = ps.executeQuery();
			ResultSetMetaData rmd= (ResultSetMetaData) rs.getMetaData();
			 model=(DefaultTableModel) table_1.getModel();
			int cols1 =rmd.getColumnCount();
			String[] colName1= new String[cols1];
			for(int i=0;i<cols1;i++) {
				colName1[i]=rmd.getColumnName(i+1);
				
			}
			model.setColumnIdentifiers(colName1);
			String product,avgprice, maxquantity;
			while(rs.next()) {
				product=rs.getString(1);
				avgprice=rs.getString(2);
				maxquantity=rs.getString(3);
				
				String[] row1={product,avgprice, maxquantity};
				model.addRow(row1);
			}
			

			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
				
		// show as button
		
		JButton btnNewButton_2 = new JButton("Show as");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				whichTable=showAscomboBox.getSelectedItem().toString();
				
				if(whichTable=="Average price of products in the city")
				{
					while(model.getRowCount()>0) {
						model.removeRow(0);
						}
					
					try {
						ps=con.prepareStatement("SELECT `name` AS Product, round(AVG(`price`) ,2) AS `Average Price`,SUM(`quantity`) AS `Total Quantity`  FROM `retailerproduct` GROUP BY `name` ORDER BY `quantity` DESC;");
						
						rs = ps.executeQuery();
						ResultSetMetaData rmd= (ResultSetMetaData) rs.getMetaData();
						 model=(DefaultTableModel) table_1.getModel();
						int cols1 =rmd.getColumnCount();
						String[] colName1= new String[cols1];
						for(int i=0;i<cols1;i++) {
							colName1[i]=rmd.getColumnName(i+1);
							
						}
						model.setColumnIdentifiers(colName1);
						String product,avgprice, maxquantity;
						while(rs.next()) {
							product=rs.getString(1);
							avgprice=rs.getString(2);
							maxquantity=rs.getString(3);
							
							String[] row1={product,avgprice, maxquantity};
							model.addRow(row1);
						}
						

						
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
					
					
					
				}
				

				
				
				 if(whichTable=="Average price with quantity (Area wise)") {
					
					while(model.getRowCount()>0) {
						model.removeRow(0);
					
					}

					try {
						
						//Query 16(Show Average price with quantity (Area wise))
						
						ps=con.prepareStatement("SELECT `name`,`area`,round(AVG(`price`),2)AS `Average Price`,SUM(`quantity`)AS `Total Quantity` FROM `retailerproduct` GROUP BY `name`,`area` ORDER BY `quantity` DESC;");
						
						rs = ps.executeQuery();
						ResultSetMetaData rmd= (ResultSetMetaData) rs.getMetaData();
						 model=(DefaultTableModel) table_1.getModel();
						int cols1 =rmd.getColumnCount();
						String[] colName1= new String[cols1];
						for(int i=0;i<cols1;i++) {
							colName1[i]=rmd.getColumnName(i+1);
							
						}
						model.setColumnIdentifiers(colName1);
						String product,area,avgprice, maxquantity;
						while(rs.next()) {
							product=rs.getString(1);
							area=rs.getString(2);
							avgprice=rs.getString(3);
							maxquantity=rs.getString(4);
							
							String[] row1={product,area,avgprice, maxquantity};
							model.addRow(row1);
						}

						
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
					
				}
				
				else if(whichTable=="Average price and Maximum quantity (Area wise)") {
					
					while(model.getRowCount()>0) {
						model.removeRow(0);
					
					}

					try {
						
						//Query 17(Show Average price and Maximum quantity (Area wise))
						
						ps=con.prepareStatement("SELECT `name`,`area`,round(AVG(`price`),2)AS `Average Price`,MAX(`quantity`)AS`Max Quantity` FROM `retailerproduct` GROUP BY `name`,`area` ORDER BY `quantity` DESC;");
						
						rs = ps.executeQuery();
						ResultSetMetaData rmd= (ResultSetMetaData) rs.getMetaData();
						 model=(DefaultTableModel) table_1.getModel();
						int cols1 =rmd.getColumnCount();
						String[] colName1= new String[cols1];
						for(int i=0;i<cols1;i++) {
							colName1[i]=rmd.getColumnName(i+1);
							
						}
						model.setColumnIdentifiers(colName1);
						String product,area,avgprice, maxquantity;
						while(rs.next()) {
							product=rs.getString(1);
							area=rs.getString(2);
							avgprice=rs.getString(3);
							maxquantity=rs.getString(4);
							
							String[] row1={product,area,avgprice, maxquantity};
							model.addRow(row1);
						}

						
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
				}

				
			}
			
			
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBounds(602, 130, 104, 23);
		MyProductFrame.getContentPane().add(btnNewButton_2);
		
		
		
		
		
		
		
		
		//table 1
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			
			//Query 18(Show logged in retailer products)
			
			ps=con.prepareStatement("select name , price, quantity, area from retailerProduct where retailerID=?");
			ps.setInt(1,retailerforeignkey);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd= (ResultSetMetaData) rs.getMetaData();
			 model1=(DefaultTableModel) table.getModel();
			int cols =rsmd.getColumnCount();
			String[] colName= new String[cols];
			for(int i=0;i<cols;i++) {
				colName[i]=rsmd.getColumnName(i+1);
				
			}
			model1.setColumnIdentifiers(colName);
			String name,price, quantity, area;
			while(rs.next()) {
				name=rs.getString(1);
				price=rs.getString(2);
				quantity=rs.getString(3);
				area=rs.getString(4);
				String[] row={name,price, quantity, area};
				model1.addRow(row);
			}

			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	
		
		
		
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
		MyProductFrame.getContentPane().setLayout(null);
		MyProductFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnProducts = new JButton("My Products");
		btnProducts.setForeground(new Color(250, 240, 230));
		btnProducts.setFont(new Font("Arial", Font.BOLD, 20));
		btnProducts.setBackground(new Color(30, 144, 255));
		btnProducts.setBounds(0, 137, 177, 56);
		panel_2.add(btnProducts);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wlc= new welcome();
				wlc.welcomeFrame.setVisible(true);
				MyProductFrame.dispose();
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
				RetailerProfile rtp= new RetailerProfile();
				rtp.RetailerProfileFrame.setVisible(true);
				MyProductFrame.dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(0, 83, 177, 56);
		panel_2.add(btnNewButton);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerDashboard rtdb= new RetailerDashboard();
				rtdb.RetailerDashboardFrame.setVisible(true);
				MyProductFrame.dispose();
				
			}
		});
		btnDashboard.setForeground(new Color(250, 240, 230));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		btnDashboard.setBackground(new Color(0, 128, 128));
		btnDashboard.setBounds(0, 28, 177, 56);
		panel_2.add(btnDashboard);
		MyProductFrame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Retailer Products");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 232, 43);
		panel_1.add(lblNewLabel_2);
		MyProductFrame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(187, 93, 390, 282);
		panel.setBackground(new Color(230, 230, 250));
		MyProductFrame.getContentPane().add(panel);		
		
		
		String[] product= {"Potato","Tomato","Chilli","Onion","Carrot","Capsicum","Cucumber","Radish","Ginger","Pumpkin"};
		panel.setLayout(null);

		JComboBox productcomboBox = new JComboBox(product);
		productcomboBox.setBounds(210, 45, 132, 30);
		productcomboBox.setEditable(true);
		panel.add(productcomboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Select Product");
		lblNewLabel_3.setBounds(21, 45, 147, 30);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Price");
		lblNewLabel_3_1_1.setBounds(21, 129, 147, 30);
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Quantity");
		lblNewLabel_3_1_2.setBounds(21, 173, 147, 30);
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblNewLabel_3_1_2);
		
		pricetextField = new JTextField();
		pricetextField.setBounds(210, 137, 132, 20);
		pricetextField.setColumns(10);
		panel.add(pricetextField);
		
		quantitytextField = new JTextField();
		quantitytextField.setBounds(210, 181, 132, 20);
		quantitytextField.setColumns(10);
		panel.add(quantitytextField);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(79, 248, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String product = productcomboBox.getSelectedItem().toString();
				int prID=  productID( product);
				String area = areacomboBox.getSelectedItem().toString();
				String price = pricetextField.getText();
				String quantity = quantitytextField.getText();
				if(product.isEmpty()||area.isEmpty()||price.isEmpty()||quantity.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
					return;
				}
				
				try {
					ps=con.prepareStatement("select * from retailerInfo where phone=?");
					ps.setString(1,welcome.retailerLoginPhn);
					rs = ps.executeQuery();
					if(rs.next()) {

					  retailerforeignkey=rs.getInt("retailerID");	
						
					}
					
					//Query 19(Insert product info to productinfo table)
					
					ps = con.prepareStatement("insert into retailerProduct (retailerProductID ,retailerID ,name,price,quantity,area) values (?,?,?,?,?,?)");
					ps.setInt(1, prID);
					ps.setInt(2, retailerforeignkey);
					ps.setString(3, product);
					ps.setString(4, price);
					ps.setString(5, quantity);
					ps.setString(6, area);

					ps.executeUpdate();
					//add the current product
					String[] updateRow= {product, price,quantity,area};
					model1.addRow(updateRow);
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Successfully Added");


			}
		});
		btnNewButton_1.setBackground(new Color(60, 179, 113));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Cleared");
				pricetextField.setText("");
				quantitytextField.setText("");
			}
		});
		btnNewButton_1_1.setBounds(217, 248, 89, 23);
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Select Area");
		lblNewLabel_3_1.setBounds(21, 86, 147, 30);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblNewLabel_3_1);
		String[] area= {"Mohammadpur","Shyamoli","Mirpur","Dhanmondi","Tejgaon","Motijheel","Gulshan","Jatra Bari","Mohakhali","Banani"};

		 areacomboBox = new JComboBox(area);
		 areacomboBox.setBounds(210, 89, 132, 30);
		areacomboBox.setEditable(true);
		panel.add(areacomboBox);
		

		
	}
}

