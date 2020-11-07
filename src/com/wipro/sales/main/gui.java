package com.wipro.sales.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;

class gui implements ActionListener{
	JFrame f;
	JLabel l;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JTable table;
	DefaultTableModel tableModel;
    ButtonGroup G1; 
	gui()
	{
		f=new JFrame("Stock and Sales");
		f.setVisible(true);
		f.setSize(480,500);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(240,180,140));
		
		
		l=new JLabel("Choose One");
		l.setBounds(106, 11, 199, 46);
		l.setFont(new Font("Calibri Light", Font.BOLD, 16));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l);
		
		r1=new JRadioButton("Insert Stock");
		r1.setBackground(new Color(240, 180, 140));
		r1.setBounds(35, 58, 109, 23);
		f.add(r1);
		
		r2=new JRadioButton("Delete Stock");
		r2.setBackground(new Color(240, 180, 140));
		r2.setBounds(279, 58, 119, 23);
		f.add(r2);
		
		r3 = new JRadioButton("Insert Sales");
		r3.setBounds(35,100,109,23);
		r3.setBackground(new Color(240, 180, 140));
		f.add(r3);
		
		r4 = new JRadioButton("Veiw Sales Report");
		r4.setBackground(new Color(240, 180, 140));
		r4.setBounds(279, 100, 135, 23);
		f.add(r4);
		
		b1  = new JButton("Proceed");
		b1.setBounds(163, 141, 89, 23);
		b1.addActionListener(this);
		f.add(b1);
		
		G1=new ButtonGroup();
		G1.add(r1);
		G1.add(r2);
		G1.add(r3);
		G1.add(r4);
		
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		l6=new JLabel();
		t2=new JTextField();
		t1=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		b2=new JButton();
		String []col= {"ProductID","ProductName","ProductUnitPrice","ProfitAmount","QuantitySold","SalesDate","SalesID","SalesPricePerUnit"};
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			if(r2.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				table.setVisible(false);
				l1.setText("Enter the Product ID");
				l1.setBounds(30, 200, 300, 20);
				l1.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l1);
				
				t1.setText("");
				t1.setBounds(240, 200, 100, 20);
				f.add(t1);
				
				b2.setText("Delete");
				b2.setBounds(163,250,89,23);
				b2.addActionListener(this);
				f.add(b2);
				l1.setVisible(true);
				t1.setVisible(true);
				b2.setVisible(true);
			}
			if(r1.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				table.setVisible(false);
				l1.setText("Enter the Product ID");
				l1.setBounds(30, 200, 300, 20);
				l1.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l1);
				
				t1.setText("");
				t1.setBounds(240, 200, 100, 20);
				f.add(t1);
				
				l2.setText("Enter the Product Name");
				l2.setBounds(30,220,300,20);
				l2.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l2);
				
				t2.setText("");
				t2.setBounds(240, 220, 100, 20);
				f.add(t2);
				
				l3.setText("Enter the Product Unit Price");
				l3.setBounds(30,240,300,20);
				l3.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l3);
				
				t3.setText("");
				t3.setBounds(240, 240, 100, 20);
				f.add(t3);
				
				l4.setText("Enter the Quantity");
				l4.setBounds(30,260,300,20);
				l4.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l4);
				
				t4.setText("");
				t4.setBounds(240, 260, 100, 20);
				f.add(t4);
				
				l5.setText("Enter the Reorder Level");
				l5.setBounds(30,280,300,20);
				l5.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l5);
				
				t5.setText("");
				t5.setBounds(240, 280, 100, 20);
				f.add(t5);
				
				b2.setText("Insert");
				b2.setBounds(163,320,89,23);
				b2.addActionListener(this);
				f.add(b2);
				l1.setVisible(true);
				t1.setVisible(true);
				l2.setVisible(true);
				t2.setVisible(true);
				l3.setVisible(true);
				t3.setVisible(true);
				l4.setVisible(true);
				t4.setVisible(true);
				l5.setVisible(true);
				t5.setVisible(true);
				b2.setVisible(true);
			}
			if(r3.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				table.setVisible(false);
				l1.setText("Enter the Product ID");
				l1.setBounds(30, 200, 300, 20);
				l1.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l1);
				
				t1.setText("");
				t1.setBounds(240, 200, 100, 20);
				f.add(t1);
				
				l2.setText("Enter the Quantity Sold");
				l2.setBounds(30,220,300,20);
				l2.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l2);
				
				t2.setText("");
				t2.setBounds(240, 220, 100, 20);
				f.add(t2);
				
				l3.setText("Enter the Sales Date in dd/MM/YYYY");
				l3.setBounds(30,240,300,20);
				l3.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l3);
				
				t3.setText("");
				t3.setBounds(240, 240, 100, 20);
				f.add(t3);
				
				l4.setText("Enter the Sales ID");
				l4.setBounds(30,260,300,20);
				l4.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l4);
				
				t4.setText("");
				t4.setBounds(240, 260, 100, 20);
				f.add(t4);
				
				l5.setText("Enter the Sales Price per Unit");
				l5.setBounds(30,280,300,20);
				l5.setFont(new Font("Calibri Light", Font.BOLD, 13));
				f.add(l5);
				
				t5.setText("");
				t5.setBounds(240, 280, 100, 20);
				f.add(t5);
				
				b2.setText("Insert");
				b2.setBounds(163,320,89,23);
				b2.addActionListener(this);
				f.add(b2);
				l1.setVisible(true);
				t1.setVisible(true);
				l2.setVisible(true);
				t2.setVisible(true);
				l3.setVisible(true);
				t3.setVisible(true);
				l4.setVisible(true);
				t4.setVisible(true);
				l5.setVisible(true);
				t5.setVisible(true);
				b2.setVisible(true);
			}
			if(r4.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				table.setVisible(false);
				ArrayList<SalesReport> arr=new ArrayList<>();
				arr=Administrator.getSalesReport();
				
				
				for(int i=0;i<arr.size();i++)
				{
					Object[] data= {arr.get(i).getProductID(),arr.get(i).getProductName(),arr.get(i).getProductUnitPrice(),arr.get(i).getProductUnitPrice(),arr.get(i).getProfitAmount(),arr.get(i).getQuantitySold(),arr.get(i).getSalesDate(),arr.get(i).getSalesID(),arr.get(i).getSalesPricePerUnit()};
					tableModel.addRow(data);
				}
				table.setBounds(0, 200, 450, 20);
				f.add(table);
				table.setVisible(true);
				
			}
		}
		if(e.getSource()==b2)
		{
			if(r2.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				b2.setVisible(false);
				JOptionPane.showMessageDialog(null, Administrator.deleteStock(t1.getText()));
			}
			if(r1.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				Product ob=new Product();
				ob.setProductID(t1.getText());
				ob.setProductName(t2.getText());
				ob.setProductUnitPrice(Double.parseDouble(t3.getText()));
				ob.setQuantityOnHand(Integer.parseInt(t4.getText()));
				ob.setReorderLevel(Integer.parseInt(t5.getText()));
				JOptionPane.showMessageDialog(null, Administrator.insertStock(ob));
			}
			if(r3.isSelected())
			{
				l1.setVisible(false);
				t1.setVisible(false);
				l2.setVisible(false);
				t2.setVisible(false);
				l3.setVisible(false);
				t3.setVisible(false);
				l4.setVisible(false);
				t4.setVisible(false);
				l5.setVisible(false);
				t5.setVisible(false);
				b2.setVisible(false);
				Sales ob=new Sales();
				ob.setProductID(t1.getText());
				ob.setQuantitySold(Integer.parseInt(t2.getText()));
			    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
				try {
					ob.setSalesDate(formatter1.parse(t3.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				ob.setSalesID(t4.getText());
				ob.setSalesPricePerUnit(Integer.parseInt(t5.getText()));
				JOptionPane.showMessageDialog(null, Administrator.insertSales(ob));
			}
		}
	}
	
}