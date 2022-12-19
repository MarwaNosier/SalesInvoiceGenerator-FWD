/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Marwa Mahmoud
 */
public class DialogForHeader extends JDialog {
     private JTextField TextFieldCustomerName;
    private JTextField TextFieldInvoiceDate;


    private JLabel CustomerName;

    private JLabel InvoiceDate;

    private JButton ButtonOk;

    private JButton ButtonCancel;

    public DialogForHeader(SIG_Frame frame) {
        TextFieldCustomerName = new JTextField(25);
        CustomerName = new JLabel("Customer Name");
        add(CustomerName);
        add(TextFieldCustomerName);


        TextFieldInvoiceDate = new JTextField(25);
        InvoiceDate = new JLabel("Invoice Date");
        add(InvoiceDate);
        add(TextFieldInvoiceDate);


        ButtonOk = new JButton("OK");
        ButtonOk.setActionCommand("OkCreatNewInvoice");
        ButtonOk.addActionListener(frame.getListenerBtns());
        add(ButtonOk);


        ButtonCancel = new JButton("Cancel");
        ButtonCancel.setActionCommand("CancelNewInvoice");
        ButtonCancel.addActionListener(frame.getListenerBtns());
        add(ButtonCancel);

        setLayout(new GridLayout(8, 6));
        pack();

    }

    public JTextField getJTextFieldCustomerName() {
        return TextFieldCustomerName;
    }

    public JTextField getJTextFieldInvoiceDate() {
        return TextFieldInvoiceDate;
    }


}

