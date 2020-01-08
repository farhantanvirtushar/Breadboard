import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IC extends JPanel {

    Data data;
    GridBagLayout grid;
    GridBagConstraints constraints;
    IC(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        setLayout(grid);

        ImageIcon icon1=new ImageIcon(getClass().getResource("/imageAndIcon/emptyIC.png"));
        Image scaleImage1 = icon1.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        ImageIcon emptyIC=new ImageIcon(scaleImage1);


        for(int i=0;i<5;i++)
        {
            data.ic[i]=new JButton(emptyIC);
            data.ic[i].setBackground(Color.WHITE);
            add(data.ic[i]);
            data.ic[i].setActionCommand(i+"");
            data.ic[i].addActionListener(new IClistener(data,i));
            constraints.gridx=i;
            constraints.gridy=0;
            constraints.ipady=0;
            constraints.ipadx=56;
            grid.setConstraints(data.ic[i],constraints);
        }
    }
}