package gui;

import javax.swing.*;

public class PanelTempOutput
    extends JPanel
{

    private JTextArea taOutput;

    public PanelTempOutput()
    {


        taOutput = new JTextArea(15, 60);

        add(taOutput);

    }


    public void DisplayTextInTextArea(String data)
    {
        taOutput.append(data +"\n");

    }

}
