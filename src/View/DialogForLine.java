/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.GridLayout;

/**
 *
 * @author Marwa Mahmoud
 */
public class DialogForLine   extends JDialog {
    
    private final JLabel LabelitemPrice;

    private final JButton ButtonOk;

    private final JButton ButtonCancel;

    private final JTextField itemPriceField;

    private final JLabel LabelitemName;

    private final JLabel LabelitemCount;

    private final JTextField TextFielditemName;

    private final JTextField TextFielditemCount;


    public DialogForLine(SIG_Frame frame) {
        TextFielditemName = new JTextField(25);
        LabelitemName = new JLabel("Item Name");
        add(LabelitemName);
        add(TextFielditemName);

        TextFielditemCount = new JTextField(25);
        LabelitemCount = new JLabel("Item Count");
        add(LabelitemCount);
        add(TextFielditemCount);

        itemPriceField = new JTextField(25);
        LabelitemPrice = new JLabel("Item Price");  
        add(LabelitemPrice);
        add(itemPriceField);

        ButtonOk = new JButton("OK");
        ButtonCancel = new JButton("Cancel");
        ButtonOk.setActionCommand("OkCreatNewLine");
        ButtonOk.addActionListener(frame.getListenerBtns());
        add(ButtonOk);

        
        ButtonCancel.setActionCommand("CancelNewLine");
        ButtonCancel.addActionListener(frame.getListenerBtns());  
        add(ButtonCancel);

        setLayout(new GridLayout(9, 6));
    
        pack();

    }

    public JTextField getTextFielditemName() {
        return TextFielditemName;
    }

    public JTextField getTextFielditemCount() {
        return TextFielditemCount;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }



}

