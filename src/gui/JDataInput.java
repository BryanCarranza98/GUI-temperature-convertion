package gui;

import domain.Temperature;
import domain.TemperatureException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import org.apache.logging.log4j.*;

public class JDataInput
    extends JPanel
{
    private static Logger logger = LogManager.getLogger(JDataInput.class);

    private JLabel lblInput;
    private JTextField txtInput;
    private JLabel lblMessage;


    public JDataInput() {

    }

    public JDataInput(String caption) {

        lblInput = new JLabel(caption);
        txtInput = new JTextField(20);
        lblMessage = new JLabel(" ");
        lblMessage.setForeground(Color.red);


        setLayout(new GridLayout(2, 1));
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();


        row1.add(lblInput);
        row1.add(txtInput);


        row2.add(lblMessage);

        this.add(row1);
        this.add(row2);


    }


    public double getDoubleValue()
    {
        logger.debug("INSIDE getDoubleValue ");

        double returnValue = 0.00;
        lblMessage.setText("");
        try
        {
            returnValue = Double.parseDouble( txtInput.getText() );
        }
        catch (NumberFormatException  nfex)
        {
            lblMessage.setText(nfex.toString());
            throw nfex; // will not show on the panel
        }
        return returnValue ;
    }


    public double getIntegerValue()
    {
        int returnValue = 0;
        lblMessage.setText("");
        try
        {
            returnValue = Integer.parseInt( txtInput.getText() );
        }
        catch (NumberFormatException  nfex)
        {
            lblMessage.setText(nfex.toString());
            throw nfex; // will not show on the panel
        }
        return returnValue ;
    }

    public String getStringValue()
    {
        String returnValue = "";
        lblMessage.setText("");
        try
        {
            returnValue =  txtInput.getText() ;
        }
        catch (NumberFormatException  nfex)
        {
            lblMessage.setText(nfex.toString());
            throw nfex; // will not show on the panel
        }
        return returnValue;
    }



    public void setMessage(String message)
    {

        lblMessage.setText(message);

    }




}
