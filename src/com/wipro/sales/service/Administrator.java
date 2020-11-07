package com.wipro.sales.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.util.DBUtil;

public class Administrator {
	public static String insertStock(Product stockObj)
	{
		if(stockObj==null)
		{
			return "Data not Valid for insertion";
		}
		if(stockObj.getProductName().length()<2)
		{
			return "Data not Valid for insertion";
		}
		else
		{
			String id=StockDao.generateProductID(stockObj.getProductName());
			stockObj.setProductID(id);
			StockDao.insertStock(stockObj);
			return id+"added";
		}
	}
	public static String deleteStock(String ProductID)
	{
		if(StockDao.deleteStock(ProductID)==0)
		{
			return "record cannot deleted";
		}
		else
		{
			
			return "deleted";
		}
	}
	public static String insertSales(Sales salesobj) 
	{
		if(salesobj==null)
		{
			return "object not valid";
		}
		Connection c=DBUtil.getDBConnections();
		try {
			PreparedStatement ps=c.prepareStatement("select Quantity_On_Hand from TBL_STOCK WHERE Product_ID=?");
			ps.setString(1,salesobj.getProductID());
			ResultSet rs=ps.executeQuery();
			if(rs==null)
			{
				return "Unknown product for sales";
			}
			int qty=0;
			while(rs.next())
			{
				qty=rs.getInt(1);
			}
			if(qty<salesobj.getQuantitySold())
			{
				return "Not enough quantity on hand for sales";
			}
			
		} catch (Exception e) {
			return "Unknown product for sales";
		}
		Date d=salesobj.getSalesDate();
		Date d1=new Date(new java.util.Date().getTime());
		if(d.compareTo(d1)>=0)
		{
			return "Invaid Date";
		}
		else
		{
			salesobj.setSalesID(SalesDao.generateSalesID(salesobj.getSalesDate()));
		}
		if(SalesDao.insertSales(salesobj)==0)
		{	
			return "Error";
		}
		else
		{
			if (StockDao.updateStock(salesobj.getProductID(), salesobj.getQuantitySold()) == 0) {
			      return "Error in stock updation";
			    }
			else
			{
				return "Sales Completed";
			}
		}
	}
	public static ArrayList<SalesReport> getSalesReport()
	{
		return SalesDao.getSalesReport();
	}
}
