package com.wipro.sales.dao;

import java.sql.*;
import java.text.*;
import java.util.*;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;

public class SalesDao {
	public static int insertSales(Sales sales)
	{
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		Connection c=DBUtil.getDBConnections();
		try {
			PreparedStatement ps=c.prepareStatement("INSERT INTO TBL_SALES VALUES (?,?,?,?,?)");
			ps.setString(1, sales.getSalesID());
			ps.setDate(2, sqlDate);
			ps.setString(3, sales.getProductID());
			ps.setInt(4, sales.getQuantitySold());
			ps.setDouble(5, sales.getSalesPricePerUnit());
			return ps.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
	}
	 public static String generateSalesID(java.util.Date date) {

		    
		    PreparedStatement ps;
			try 
			{
				ps = DBUtil.getDBConnections().prepareStatement("select seq_sales_id.nextval from dual");
				ResultSet rs = ps.executeQuery();

				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);

				if (rs.next()) 
				{
				      return "" + (year % 100) + rs.getInt(1);
				}
				else
				{
					return "";
				}
			} 
			catch (Exception e) {
				return "";			
			}
		 }
	public static ArrayList<SalesReport> getSalesReport()
	{
		ArrayList<SalesReport> mn=new ArrayList<>();
		Connection c=DBUtil.getDBConnections();
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from V_SALES_REPORT");
			while(rs.next())
			{
				SalesReport sr=new SalesReport();
				sr.setSalesID(rs.getString(1));
				sr.setSalesDate(rs.getDate(2));
				sr.setProductID(rs.getString(3));
				sr.setProductName(rs.getString(4));
				sr.setQuantitySold(rs.getInt(5));
				sr.setProductUnitPrice(rs.getDouble(6));
				sr.setSalesPricePerUnit(rs.getDouble(7));
				sr.setProfitAmount(rs.getDouble(8));
				mn.add(sr);
			}
			return mn;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return mn;
		}
		
	}
	
}
