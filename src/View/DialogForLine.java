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
    
    private final JLabel JLabelitemPrice;

    private final JButton JButtonOk;

    private final JButton JButtonCancel;

    private final JTextField itemPriceField;

    private final JLabel JLabelitemName;

    private final JLabel JLabelitemCount;

    private final JTextField JTextFielditemName;

    private final JTextField JTextFielditemCount;


    public DialogForLine(SIG_Frame frame) {
        JTextFielditemName = new JTextField(25);
        JLabelitemName = new JLabel("Item Name");

        JTextFielditemCount = new JTextField(25);
        JLabelitemCount = new JLabel("Item Count");

        itemPriceField = new JTextField(25);
        JLabelitemPrice = new JLabel("Item Price");

        JButtonOk = new JButton("OK");
        JButtonCancel = new JButton("Cancel");
        JButtonOk.setActionCommand("OkCreatNewLine");
        JButtonCancel.setActionCommand("CancelNewLine");
        JButtonOk.addActionListener(frame.getListenerBtns());
        JButtonCancel.addActionListener(frame.getListenerBtns());

        setLayout(new GridLayout(9, 6));

        add(JLabelitemName);
        add(JTextFielditemName);
        add(JLabelitemCount);
        add(JTextFielditemCount);
        add(JLabelitemPrice);
        add(itemPriceField);
        add(JButtonOk);
        add(JButtonCancel);
        pack();

    }

    public JTextField getJTextFielditemName() {
        return JTextFielditemName;
    }

    public JTextField getJTextFielditemCount() {
        return JTextFielditemCount;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }



}

