import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Switch extends JPanel {

    GridBagLayout grid;
    GridBagConstraints constraints;
    Data data;
    JRadioButton inputTerminal[];
    Switch(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();

        ImageIcon icon1=new ImageIcon(getClass().getResource("/imageAndIcon/on.png"));
        Image scaleImage1 = icon1.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(getClass().getResource("/imageAndIcon/off.png"));
        Image scaleImage2 = icon2.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);

        ImageIcon on=new ImageIcon(scaleImage1);
        ImageIcon off=new ImageIcon(scaleImage2);
        data.on=on;
        data.off=off;
        setLayout(grid);

        data.onOff=new JToggleButton[10];
        inputTerminal=new JRadioButton[10];

        for(int i=0;i<10;i++)
        {
            inputTerminal[i]=new JRadioButton();
            inputTerminal[i].setActionCommand(data.SWITCH+" "+i+" "+0);
            inputTerminal[i].addActionListener(new CellListener(data));
            add(inputTerminal[i]);
            constraints.gridx = i;
            constraints.gridy = 0;
            constraints.ipady=20;
            constraints.anchor = GridBagConstraints.CENTER;
            grid.setConstraints(inputTerminal[i], constraints);
        }

        for(int i=0;i<10;i++)
        {
            data.onOff[i]=new JToggleButton();
            data.onOff[i].setIcon(off);
            data.onOff[i].setActionCommand(i+"");
            data.onOff[i].addItemListener(new SwitchListener(on,off,data));
            data.onOff[i].setBackground(Color.WHITE);
            add(data.onOff[i]);
            constraints.gridx=i;
            constraints.gridy=1;
            constraints.ipady=0;
            constraints.anchor=GridBagConstraints.CENTER;
            grid.setConstraints(data.onOff[i],constraints);
        }


    }

}