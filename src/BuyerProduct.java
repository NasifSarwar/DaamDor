import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class BuyerProduct {

	 JFrame productframe;
	 public static int customerforeignkey;

	 private JTextField pricetextField;
	 private JTextField quantitytextField;
	 DefaultTableModel model;
	 DefaultTableModel model1;

	 private JTable table_1;
	 String whichTable;

		MyProducts pr= new MyProducts();


	 Connection con = DB.dbconnect();
	 ResultSet rs;
	 PreparedStatement ps;
	 private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerProduct window = new BuyerProduct();
					window.productframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BuyerProduct() {
		initialize();
	}

	
	private void initialize() {
		productframe = new JFrame();
		productframe.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DCL\\Desktop\\Slogo.png"));
		productframe.getContentPane().setBackground(UIManager.getColor("Button.background"));
		productframe.setBounds(100, 100, 1080, 720);
		productframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(187, 434, 377, 329);
		productframe.getContentPane().add(scrollPane);
		
		
		//table 2
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(589, 163, 465, 375);
				productframe.getContentPane().add(scrollPane_1);
				
				table_1 = new JTable();
				scrollPane_1.setViewportView(table_1);
				
				String[] show_as= {"Average price of products in the city","Average price with quantity (Area wise)","Average price and Maximum quantity (Area wise)"};
				JComboBox showAscomboBox = new JComboBox(show_as);
				showAscomboBox.setBounds(716, 130, 310, 22);
				productframe.getContentPane().add(showAscomboBox);
				
				// show as button
				
				try {
					
					//Query 20(Show Average price of products in the city)
					
					ps=con.prepareStatement("SELECT `name` AS Product, round(AVG(`price`),2)AS `Average Price`,SUM(`quantity`) AS `Total Quantity`  FROM `customerproduct` GROUP BY `name` ORDER BY `quantity` DESC;");
					
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
								
								
								
								ps=con.prepareStatement("SELECT `name` AS Product, round(AVG(`price`),2)AS `Average Price`,SUM(`quantity`) AS `Total Quantity`  FROM `customerproduct` GROUP BY `name` ORDER BY `quantity` DESC;");
								
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
						
						
						
							else if(whichTable=="Average price with quantity (Area wise)") {
							
							while(model.getRowCount()>0) {
								model.removeRow(0);
							
							}

							try {
								
								//Query 21(Show Average price with quantity (Area wise))
								
								ps=con.prepareStatement("SELECT `name`,`area`,round(AVG(`price`),2)AS `Average Price`,SUM(`quantity`)AS `Total Quantity` FROM `customerproduct` GROUP BY `name`,`area` ORDER BY `quantity` DESC;");
								
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
								
								//Query 22 (Show Average price and Maximum quantity (Area wise))
								
								ps=con.prepareStatement("SELECT `name`,`area`,round(AVG(`price`),2)AS `Average Price`,MAX(`quantity`)AS`Max Quantity` FROM `customerproduct` GROUP BY `name`,`area` ORDER BY `quantity` DESC;");
								
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
				productframe.getContentPane().add(btnNewButton_2);
				
				
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
//		 public void ShowProducts() {
		try {
			
			//Query 23 (Show logged in Customer product) 
			
			ps=con.prepareStatement("select name, price, quantity, area from customerProduct where customerID=?");
			ps.setInt(1,customerforeignkey);
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
		productframe.getContentPane().setLayout(null);
		productframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome wlc = new welcome();
				wlc.welcomeFrame.setVisible(true);
				productframe.dispose();
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
				productframe.dispose();
			}
		});
		btnNewButton.setForeground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(0, 83, 177, 56);
		panel_2.add(btnNewButton);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.setForeground(new Color(250, 240, 230));
		btnProduct.setFont(new Font("Arial", Font.BOLD, 20));
		btnProduct.setBackground(new Color(30, 144, 255));
		btnProduct.setBounds(0, 137, 177, 56);
		panel_2.add(btnProduct);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuyerDashboard df = new BuyerDashboard();
				df.dashboardframe.setVisible(true);
				productframe.dispose();
				
			}
		});
		btnDashboard.setForeground(new Color(250, 240, 230));
		btnDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		btnDashboard.setBackground(new Color(0, 128, 128));
		btnDashboard.setBounds(0, 27, 177, 56);
		panel_2.add(btnDashboard);
		productframe.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buyer Product");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_2.setBounds(455, 27, 207, 43);
		panel_1.add(lblNewLabel_2);
		productframe.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(187, 92, 377, 329);
		panel.setBackground(new Color(230, 230, 250));
		productframe.getContentPane().add(panel);
		panel.setLayout(null);
		String[] product= {"Potato","Tomato","Chilli","Onion","Carrot","Capsicum","Cucumber","Radish","Ginger","Pumpkin"};
		JComboBox productcomboBox = new JComboBox(product);
		productcomboBox.setEditable(true);
		productcomboBox.setBounds(210, 45, 132, 30);
		panel.add(productcomboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Select Product");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_3.setBounds(21, 45, 147, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Select Area");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_3_1.setBounds(21, 104, 147, 30);
		panel.add(lblNewLabel_3_1);
		String[] area= {"Mohammadpur","Shyamoli","Mirpur","Dhanmondi","Tejgaon","Motijheel","Gulshan","Jatra Bari","Mohakhali","Banani"};
		JComboBox areacomboBox = new JComboBox(area);
		areacomboBox.setEditable(true);
		areacomboBox.setBounds(210, 104, 132, 30);
		panel.add(areacomboBox);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Price");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_3_1_1.setBounds(21, 161, 147, 30);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Quantity");
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_3_1_2.setBounds(21, 212, 147, 30);
		panel.add(lblNewLabel_3_1_2);
		
		pricetextField = new JTextField();
		pricetextField.setBounds(210, 169, 132, 20);
		panel.add(pricetextField);
		pricetextField.setColumns(10);
		
		quantitytextField = new JTextField();
		quantitytextField.setColumns(10);
		quantitytextField.setBounds(210, 220, 132, 20);
		panel.add(quantitytextField);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String product = productcomboBox.getSelectedItem().toString();
				int prID=  pr.productID( product);
				String area = areacomboBox.getSelectedItem().toString();
				String price = pricetextField.getText();
				String quantity = quantitytextField.getText();
				if(product.isEmpty()||area.isEmpty()||price.isEmpty()||quantity.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter all fields");
					return;
				}
				
				try {
					

					
					ps=con.prepareStatement("select * from customerInfo where phone=?");
					ps.setString(1,welcome.customerLoginPhn);
					rs = ps.executeQuery();

					//Query 24(Insert product into customerproduct table)
					
					ps = con.prepareStatement("insert into customerProduct (customerProductID ,customerID ,name,price,quantity,area) values (?,?,?,?,?,?)");
					ps.setInt(1, prID);
					ps.setInt(2, customerforeignkey);
					ps.setString(3, product);
					ps.setString(4, price);
					ps.setString(5, quantity);
					ps.setString(6, area);

					ps.executeUpdate();
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
		btnNewButton_1.setBounds(79, 284, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Cleared");
				pricetextField.setText("");
				quantitytextField.setText("");
				
			
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.setBounds(222, 284, 89, 23);
		panel.add(btnNewButton_1_1);
		
		
		
		
	}
}
