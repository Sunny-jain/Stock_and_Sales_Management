package com.wipro.sales.dao;

import java.sql.*;

import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {
	public static int insertStock(Product stock)
	{
		Connection c=DBUtil.getDBConnections();
		try {
			PreparedStatement ps=c.prepareStatement("insert into TBL_STOCK values(?,?,?,?,?)");
			ps.setString(1,stock.productID);
			ps.setString(2,stock.productName);
			ps.setInt(3, stock.quantityOnHand);
			ps.setDouble(4, stock.productUnitPrice);
			ps.setInt(5, stock.reorderLevel);
			return ps.executeUpdate();
			} catch (SQLException e) {
				return 0;
		}
	}
	public static String generateProductID(String productName)
	{
		String s=Character.toString(productName.charAt(0))+Character.toString(productName.charAt(1));
		Connection c=DBUtil.getDBConnections();
		Statement p;
		try {
			p = c.createStatement();
			ResultSet rs=p.executeQuery("select SEQ_PRODUCT_ID.nextval FROM DUAL");
			while(rs.next())
			{
				s=s+rs.getString(1);
			}
			return s;
		} catch (Exception e) {
			return s;
		}	
	}
	public static int updateStock(String productID,int soldQTY)
	{
		Connection c=DBUtil.getDBConnections();
		try {
			PreparedStatement ps=c.prepareStatement("update TBL_STOCK set Quantity_On_Hand=Quantity_On_Hand-"+soldQTY+" where Product_ID='"+productID+"'");
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.print("NOT FOUND");
		}
		return 0;
	}
	public Product getStock(String ProductID)
	{
		Product o=new Product();
		Connection c=DBUtil.getDBConnections();
		Statement s;
		try {
			s = c.createStatement();
			ResultSet rs=s.executeQuery("select * from TBL_STOCK where Product_ID="+ProductID);
			while(rs.next())
			{
				o.setProductID(rs.getString(1));
				o.setProductName(rs.getString(2));
				o.setProductUnitPrice(rs.getDouble(3));
				o.setQuantityOnHand(rs.getInt(4));
				o.setReorderLevel(rs.getInt(5));
			}
			return o;

		} catch (Exception e) {
			return o;	
		}
		
	}
	public static int deleteStock(String productID)
	{
		Connection c=DBUtil.getDBConnections();
		try {
			  PreparedStatement ps = c.prepareStatement("delete from tbl_stock where product_id = ?");
			    ps.setString(1, productID);
			    return ps.executeUpdate();
		} catch (Exception e) {
			return 0;
		}
	}
}
