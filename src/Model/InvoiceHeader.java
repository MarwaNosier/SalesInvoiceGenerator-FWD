/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Marwa Mahmoud
 */
public class InvoiceHeader {
     private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> lines ;
    private DateFormat d=new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceHeader() {
    }

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }
    // ** Getters $$ Setter **//
    public int getinvoiceNum() {
        return invoiceNum;
    }

    public void setinvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getinvoiceDate() {
        return invoiceDate;
    }
    
    public void setinvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines==null) {
            lines=new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public double getTotalInvoice(){
        double total=0.0;
        for (int i = 0; i < getLines().size(); i++) {
            total += lines.get(i).getTotalLine();
        }

        return total;

    }

    @Override
    public String toString() {
        return  invoiceNum + ","+ d.format(invoiceDate)+ "," + customerName   ;
    }


}

 

