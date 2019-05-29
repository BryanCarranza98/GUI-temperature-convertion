package main;

import domain.Temperature;
import domain.TemperatureException;
import gui.FrameTemp;
import oracle.jvm.hotspot.jfr.JFR;
import org.apache.logging.log4j.*;

import javax.swing.*;

public class DriverTemp
{
    private static Logger logger = LogManager.getLogger(DriverTemp.class);



    public static void main(String[] args)
    {
        logger.debug("INSIDE DRIVER MAIN ");



        FrameTemp frmApp = new FrameTemp();
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApp.setSize(800, 400);
        frmApp.setVisible(true);





    }


}
