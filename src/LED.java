import javax.swing.*;
import java.awt.*;

public class LED extends JPanel {

    Data data;
    GridBagLayout grid;
    GridBagConstraints constraints;
    JRadioButton inputTerminal[];
    LED(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        setLayout(grid);
        inputTerminal=new JRadioButton[10];
        for(int i=0;i<10;i++)
        {
            data.light[i] = new JButton();
            data.light[i].setIcon(data.offBulb);
            data.light[i].setBackground(Color.WHITE);
            add(data.light[i]);
            constraints.gridx = i;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.CENTER;
            grid.setConstraints(data.light[i], constraints);
        }
        for(int i=0;i<10;i++)
        {
            inputTerminal[i]=new JRadioButton();
            inputTerminal[i].setActionCommand(data.CELL+" "+(100+i)+" "+0);
            inputTerminal[i].addActionListener(new CellListener(data));
            add(inputTerminal[i]);
            constraints.gridx=i;
            constraints.gridy=1;
            constraints.ipady=20;
            constraints.anchor=GridBagConstraints.CENTER;
            grid.setConstraints(inputTerminal[i],constraints);
        }

    }
}
