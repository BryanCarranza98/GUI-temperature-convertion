package gui;


import javax.swing.*;
import java.awt.*;
import org.apache.logging.log4j.*;

public class FrameTemp
    extends JFrame
{
    private static Logger logger = LogManager.getLogger(FrameTemp.class);

    /// owns both input and output they are inside here

    private PanelTempInput pnlInput;
    private PanelTempOutput pnlOutput;


    public FrameTemp()
    {
        logger.debug("INSIDE FRAMETEMP ");

        pnlInput = new PanelTempInput();
        pnlOutput = new PanelTempOutput();

        pnlInput.setRefOutputPanelReference(pnlOutput); // passing in the output panel


        add(pnlInput, BorderLayout.WEST);
        add(pnlOutput, BorderLayout.EAST);

    }



}
