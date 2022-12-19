/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 *
 * @author Marwa Mahmoud
 */
public class InvoiceLineTable extends AbstractTableModel {
    
 private ArrayList <InvoiceLine> linesArr;

    public InvoiceLineTable(ArrayList<InvoiceLine> linesArr) {
        this.linesArr = linesArr;
    }

    @Override
    public int getRowCount() {
        if (linesArr==null) {
            return 0;
        }
        return linesArr.size() ;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine Row=linesArr.get(rowIndex);
        if(columnIndex==0){
             return Row.getHeader().getinvoiceNum();
        }else if(columnIndex==1){
             return Row.getItemName();
        }else if(columnIndex==2){
            return Row.getitemPrice();
        }else if(columnIndex==3){
            return Row.getCount();
        }else if(columnIndex==4){
            return Row.getTotalLine();
        }else{
            return null;
        }
    }
    @Override
    public String getColumnName(int column){
        
        if(column==0){
            return "No.";
        } else if(column==1){
            return "Item Name";
        }else if(column==2){
             return "Item Price";
        }else if(column==3){
                return "Count";
        }else if(column==4){
            return "Item Total";
        }else{
             return "";
        }

    }

}
