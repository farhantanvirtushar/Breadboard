import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JFrame {

    Data data;
    GridBagLayout grid;
    GridBagConstraints constraints;
    int i;
    String str[];
    Image temp;
    ImageIcon image[];
    ImageIcon icon1;
    JLabel helpCommand;
    JLabel helpImage;
    int height;
    int weidth;

    HelpMenu(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        setLayout(grid);
        setSize(1050,700);
        setVisible(true);
        setTitle("How to use");

        i=0;
        height=1000;
        weidth=500;
        str=new String[8];
        str[0]="To connect to cell with wire , first click on the \"Connect\" option in the left top corner. ";
        str[1]="Then click on two points which you want to connect";
        str[2]="Click on the buttons (as shown in figure) to select any IC . ";
        str[3]="Then choose IC from the list";
        str[4]="Click on \"on\" , \"off\" buttons to turn on or off switchs";
        str[5]="Set frequency of clock pulse";
        str[6]="To connect two cells , first click on the \"Disconnect\" option in the left top corner. ";
        str[7]="Then click on two points which you want to disconnect";

        image=new ImageIcon[8];

        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/howToConnect1.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[0]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/howToConnect2.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[1]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/selectIC.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[2]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/selectIC2.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[3]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/clickOnButton.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[4]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/setFrequency.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[5]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/disconnect1.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[6]=new ImageIcon(temp);
        icon1=new ImageIcon(getClass().getResource("/imageAndIcon/disconnect2.png"));
        temp = icon1.getImage().getScaledInstance(height, weidth,Image.SCALE_DEFAULT);
        image[7]=new ImageIcon(temp);

        helpCommand=new JLabel(str[0]);
        helpCommand.setForeground(Color.BLUE);
        helpImage= new JLabel(image[0]);

        constraints.insets=new Insets(10,10,10,10);
        add(helpCommand);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(helpCommand,constraints);

        add(helpImage);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(helpImage,constraints);

        JButton next=new JButton("Next");
        JButton previous=new JButton("Previous");

        add(previous);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.ipadx=100;
        constraints.anchor=GridBagConstraints.WEST;
        grid.setConstraints(previous,constraints);

        add(next);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.anchor=GridBagConstraints.EAST;
        grid.setConstraints(next,constraints);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(i<7)
                {
                    i++;
                }
                helpCommand.setText(str[i]);
                helpImage.setIcon(image[i]);
            }
        });
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(i>0)
                {
                    i--;
                }
                helpCommand.setText(str[i]);
                helpImage.setIcon(image[i]);
            }
        });

    }
}
