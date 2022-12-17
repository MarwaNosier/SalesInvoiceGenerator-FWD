/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Marwa Mahmoud
 */
public class InvoiceLine {
    
  private InvoiceHeader header ;
    private double itemPrice;
    private int count;
    private String itemName;


    public InvoiceLine() {
    }

    public InvoiceLine(InvoiceHeader header, String itemName, double itemPrice, int count) {
        this.header = header;

        this.itemName = itemName;

        this.itemPrice = itemPrice;

        this.count = count;
    }

    public InvoiceHeader getHeader() {
        return header;
    }


    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return itemName;
    }



    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getitemPrice() {
        return itemPrice;
    }



    public void setitemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalLine(){
        return count * itemPrice;
    }

    @Override
    public String toString() {

        return  header.getinvoiceNum() + "," + itemName + "," + itemPrice + "," + count ;
    }


}

