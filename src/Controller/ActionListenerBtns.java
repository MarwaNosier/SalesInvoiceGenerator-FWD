/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.DialogForHeader;
import View.DialogForLine;
import View.SIG_Frame;
import Model.InvoiceHeader;
import Model.InvoiceLine;
import Model.InvoiceLineTable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;


/**
 *
 * @author Marwa Mahmoud
 */
public class ActionListenerBtns  implements ActionListener{
    

    private SIG_Frame frame;
    private DialogForHeader dialogForHeader ;
    private DialogForLine dialogForLine;

    public ActionListenerBtns(SIG_Frame frame) {
        this.frame = frame;
    }

  


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Create Invoice"){
             CreateNewInvoice();
        }else if(e.getActionCommand()=="Delete Invoice"){
              DeleteInvoice();
        }else if(e.getActionCommand()=="Add Item"){
              Save();
        }else if(e.getActionCommand()=="Delete Item"){
                 Cancel();
        }else if(e.getActionCommand()=="OkCreatNewInvoice"){
            OkCreatNewInvoice();
        }else if(e.getActionCommand()=="CancelNewInvoice"){
             CancelNewInvoice();
        }
         else if(e.getActionCommand()=="OkCreatNewLine"){
              OkCreatNewLine();
        }else if(e.getActionCommand()=="CancelNewLine"){
             CancelNewLine();
        }  
    }

    private void CreateNewInvoice() {
        dialogForHeader=new DialogForHeader(frame);

        dialogForHeader.setVisible(true);
    }


    private void DeleteInvoice() {
        int indexOfSelectedRow=frame.getjTable_Invoice().getSelectedRow();
        if (indexOfSelectedRow != -1) {
            frame.getInvoicesArr().remove(indexOfSelectedRow);
            frame.getHeaderTable().fireTableDataChanged();
            frame.getjTable_Items().setModel(new InvoiceLineTable(null)) ;
            frame.setLinesArr(null);
            frame.getjTextField_CustomerName().setText("");
            frame.getjLabel_InvoiceNumber().setText("");
            frame.getjLabel_InvoiceTotal().setText("");
            frame.getjTextField_InvoiceDate().setText("");

            printInvoices();

        }
    }

    private void Save() {

        dialogForLine=new DialogForLine(frame);

        dialogForLine.setVisible(true);
    }

    private void Cancel() {
        int indexOfSelectedRow=frame.getjTable_Items().getSelectedRow();

        int indexOfSelectedRowHeader=frame.getjTable_Invoice().getSelectedRow();

        if (indexOfSelectedRow != -1) {

            frame.getLinesArr().remove(indexOfSelectedRow);

            InvoiceLineTable lineTable = (InvoiceLineTable) frame.getjTable_Items().getModel();

            lineTable.fireTableDataChanged();


            frame.getHeaderTable().fireTableDataChanged();

            InvoiceHeader h =frame.getInvoicesArr().get(indexOfSelectedRow);


            frame.getjLabel_InvoiceTotal().setText(h.getTotalInvoice()+"");
        }
        frame.getjTable_Invoice().setRowSelectionInterval(indexOfSelectedRowHeader, indexOfSelectedRowHeader);
        printInvoices();

    }

    private void OkCreatNewInvoice() {
        dialogForHeader.setVisible(false);
        String S1 = dialogForHeader.getJTextFieldCustomerName().getText() ;
        String S2=dialogForHeader.getJTextFieldInvoiceDate().getText();
        Date date=new Date();
        try {
            date =SIG_Frame.date.parse(S2);
        } catch (ParseException e ) {
            JOptionPane.showMessageDialog(frame, "Wrong Date Format!!", "Wrong Date Format", JOptionPane.ERROR_MESSAGE);
        } 
        int num=0;
        for(InvoiceHeader header : frame.getInvoicesArr() ){
            if (header.getinvoiceNum()>num) {
                num=header.getinvoiceNum();
            }
        }
        num++;
        InvoiceHeader newheader=new InvoiceHeader(num, date, S1);
        frame.getInvoicesArr().add(newheader);
        frame.getHeaderTable().fireTableDataChanged();
        dialogForHeader.dispose();
        dialogForHeader=null;
        printInvoices();
    }

    private void CancelNewInvoice() {
        dialogForHeader.setVisible(false);
        dialogForHeader.dispose();
        dialogForHeader=null;

    }

    private void OkCreatNewLine() {
        dialogForLine.setVisible(false);
        String s1=dialogForLine.getJTextFielditemName().getText();
        String s2=dialogForLine.getJTextFielditemCount().getText();
        String s3 =dialogForLine.getItemPriceField().getText();
        int count=1;
        double price=1.0;
        try {
            count = Integer.parseInt(s2);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please Enter valid Count ", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(s3);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please Enter valid price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }

        int indexOfSelectedRow=frame.getjTable_Invoice().getSelectedRow();
        if (indexOfSelectedRow != -1) {
            InvoiceHeader h =frame.getInvoicesArr().get(indexOfSelectedRow);
            InvoiceLine newline =new InvoiceLine(h, s1, price, count);

            frame.getLinesArr().add(newline);
            InvoiceLineTable lineTable = (InvoiceLineTable) frame.getjTable_Items().getModel();
            lineTable.fireTableDataChanged();

            frame.getHeaderTable().fireTableDataChanged();
            frame.getjLabel_InvoiceTotal().setText(h.getTotalInvoice()+"");
        }
        frame.getjTable_Invoice().setRowSelectionInterval(indexOfSelectedRow, indexOfSelectedRow);

        dialogForLine.dispose();
        dialogForLine=null;
        printInvoices();
    }


    private void CancelNewLine() {
        dialogForLine.setVisible(false);
        dialogForLine.dispose();
        dialogForLine=null;

    }
    private void printInvoices() {
        for (InvoiceHeader header : frame.getInvoicesArr()) {
            System.out.println(header);
        }
       System.out.println("*****************");
    }
}

