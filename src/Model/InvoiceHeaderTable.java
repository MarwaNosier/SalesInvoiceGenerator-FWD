/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.SIG_Frame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


/**
 *
 * @author Marwa Mahmoud
 */
public class InvoiceHeaderTable extends AbstractTableModel {
    
 private ArrayList<InvoiceHeader> invoicesArr;

    public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoicesArr) {
        this.invoicesArr = invoicesArr;
    }

    @Override
    public int getRowCount() {
        return invoicesArr.size();
    }

    @Override
    public int getColumnCount() {
        return 4;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoiceHeader=invoicesArr.get(rowIndex) ;
        if(columnIndex==0){
             return invoiceHeader.getinvoiceNum() ;
        } else if(columnIndex==1){
             return SIG_Frame.date.format(invoiceHeader.getinvoiceDate()) ;
        }else if(columnIndex==2){
             return invoiceHeader.getCustomerName();
        }else if(columnIndex==3){
             return invoiceHeader.getTotalInvoice();
        }else{
             return null;
        }
    }
          
    @Override
    public String getColumnName(int column){
           if(column==0){
             return "No.";
        } else if(column==1){
            return "Date";
        }else if(column==2){
             return "Costumer";
        }else if(column==3){
                return "Total";
        }else{
             return "";
        }
        

    }
}
