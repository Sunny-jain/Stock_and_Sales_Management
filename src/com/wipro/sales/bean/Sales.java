package com.wipro.sales.bean;
import java.util.*;

public class Sales {

  public String salesID,productID;
  public int quantitySold;
  public double salesPricePerUnit;
  public Date salesDate;
  public String getSalesID() {
    return salesID;
  }
  public void setSalesID(String salesID) {
    this.salesID = salesID;
  }
  public String getProductID() {
    return productID;
  }
  public void setProductID(String productID) {
    this.productID = productID;
  }
  public int getQuantitySold() {
    return quantitySold;
  }
  public void setQuantitySold(int quantitySold) {
    this.quantitySold = quantitySold;
  }
  public double getSalesPricePerUnit() {
    return salesPricePerUnit;
  }
  public void setSalesPricePerUnit(double salesPricePerUnit) {
    this.salesPricePerUnit = salesPricePerUnit;
  }
  public java.util.Date getSalesDate() {
    return salesDate;
  }
  public void setSalesDate(java.util.Date salesDate) {
    this.salesDate = salesDate;
  }
  
}