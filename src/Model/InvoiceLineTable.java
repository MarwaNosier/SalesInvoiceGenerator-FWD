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
        switch(columnIndex){
            case 0:
                return Row.getHeader().getinvoiceNum();

            case 1:
                return Row.getItemName();

            case 2:
                return Row.getitemPrice();

            case 3:
                return Row.getCount();

            case 4:
                return Row.getTotalLine();

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
                return "Item Nme";

            case 2 :
                return "Item Price";

            case 3:
                return "Count";
            case 4:
                return "Item Total";

            default:
                return "";
        }

    }

}
