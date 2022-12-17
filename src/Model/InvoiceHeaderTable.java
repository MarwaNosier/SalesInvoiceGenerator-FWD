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
        switch(columnIndex){
            case 0:
                return invoiceHeader.getinvoiceNum() ;
            case 1:
                return SIG_Frame.date.format(invoiceHeader.getinvoiceDate()) ;
            case 2 :
                return invoiceHeader.getCustomerName();
            case 3 :
                return invoiceHeader.getTotalInvoice();
            default:
                return null;
        }


    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "No.";

            case 1 :
                return "Date";

            case 2 :
                return "Costumer";

            case 3:
                return "Total";
            default:
                return "";
        }

    }
}
