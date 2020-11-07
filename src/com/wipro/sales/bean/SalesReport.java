package com.wipro.sales.bean;
import java.util.*;

public class SalesReport {

    public String salesID,productID,productName;
    public Date salesDate;
    public int quantitySold;
    public double productUnitPrice,salesPricePerUnit,profitAmount;
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
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public Date getSalesDate() {
    return salesDate;
  }
  public void setSalesDate(Date salesDate) {
    this.salesDate = salesDate;
  }
  public int getQuantitySold() {
    return quantitySold;
  }
  public void setQuantitySold(int quantitySold) {
    this.quantitySold = quantitySold;
  }
  public double getProductUnitPrice() {
    return productUnitPrice;
  }
  public void setProductUnitPrice(double productUnitPrice) {
    this.productUnitPrice = productUnitPrice;
  }
  public double getSalesPricePerUnit() {
    return salesPricePerUnit;
  }
  public void setSalesPricePerUnit(double salesPricePerUnit) {
    this.salesPricePerUnit = salesPricePerUnit;
  }
  public double getProfitAmount() {
    return profitAmount;
  }
  public void setProfitAmount(double profitAmount) {
    this.profitAmount = profitAmount;
  }
}