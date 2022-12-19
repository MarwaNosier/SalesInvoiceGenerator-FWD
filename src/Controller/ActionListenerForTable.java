/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.SIG_Frame;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.InvoiceLineTable;



import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Marwa Mahmoud
 */
public class ActionListenerForTable implements ListSelectionListener{
     private SIG_Frame frame;

    public ActionListenerForTable(SIG_Frame frame) {
        this.frame = frame;
    }

    
    public void valueChanged(ListSelectionEvent e) {
        int indexOfSelectedRow=frame.getjTable_Invoice().getSelectedRow();
        System.out.println("You selected is Invoice number : " + (indexOfSelectedRow+1));

        if (indexOfSelectedRow != -1) {

            InvoiceHeader selectedRow =frame.getInvoicesArr().get(indexOfSelectedRow);
            ArrayList<InvoiceLine> lines=selectedRow.getLines();
            InvoiceLineTable lineTable=new InvoiceLineTable(lines);
            frame.setLinesArr(lines);
            frame.getjTable_Items().setModel(lineTable);
            frame.getjTextField_CustomerName().setText(selectedRow.getCustomerName());
            frame.getjLabel_InvoiceNumber().setText(selectedRow.getinvoiceNum()+"");
            frame.getjLabel_InvoiceTotal().setText(selectedRow.getTotalInvoice()+"");
            frame.getjTextField_InvoiceDate().setText(SIG_Frame.date.format(selectedRow.getinvoiceDate()));

        }

    }
   }





