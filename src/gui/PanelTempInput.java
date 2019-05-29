package gui;

import domain.Temperature;
import domain.TemperatureException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.logging.log4j.*;


public class PanelTempInput
    extends JPanel
    implements ActionListener
{

    private static Logger logger = LogManager.getLogger(PanelTempInput.class);


    private JDataInput datTemperature;
    private JComboBox<Temperature.Scale> cboScale;
    private JButton btnSubmit;

    private PanelTempOutput refOutputPanel;
    public void setRefOutputPanelReference(PanelTempOutput outputPanel)
    {
        this.refOutputPanel = outputPanel;

    }



    public PanelTempInput()
    {
        datTemperature = new JDataInput("Enter temperature value: ");
        btnSubmit = new JButton("Submit");
        btnSubmit.setActionCommand("submit");

        // either the panel itself traps the events
        btnSubmit.addActionListener(this);

        // ... or custom handler class traps the events
        btnSubmit.addActionListener(new ClickHandler());

        cboScale= new JComboBox<Temperature.Scale>();
        cboScale.addItem(Temperature.Scale.Kelvin);
        cboScale.addItem(Temperature.Scale.Celsius);
        cboScale.addItem(Temperature.Scale.Fahrenheit);


        // have individual PANELS act as "rows" for neat output layout
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();



        // add each widgets to its own "row panel"
        row1.add(cboScale);
        row2.add(datTemperature);
        row3.add(btnSubmit);

        //have each "row pannel" appear vertically down a NEW GRID LAYOUT
        this.setLayout(new GridLayout(3,1));


        // actually add teh row PANELS to the enclosing panel
        add(row1);
        add(row2);
        add(row3);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
       // System.out.println(" HEY !! THE PANEL CAUGHT THIS !!!!");
        //System.out.println(datTemperature.getDoubleValue());
        logger.debug("INSIDE actionPerformed PanelTempInput ");



        try {
            Temperature.Scale inputScale = (Temperature.Scale) cboScale.getSelectedItem();
            double inputTemp = datTemperature.getDoubleValue();
            Temperature myTemp = new Temperature(inputScale, inputTemp);

            refOutputPanel.DisplayTextInTextArea(myTemp.toString());

        }



        catch(NumberFormatException nfex) // checks if numbers are correct
        {

            datTemperature.setMessage(nfex.toString());

        }
        catch(TemperatureException tex) // check if its the correct temp
        {

            datTemperature.setMessage(tex.toString());

        }


    }





    private class ClickHandler
    implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            logger.debug("INSIDE actionPerformed clickhandler ");

            //System.out.println(" HEY !! THE BUTTON CLICK HANDLER THING CAUGHT THIS HERE!!!!");
            //System.out.println(datTemperature.getDoubleValue());


        }


    }




}
