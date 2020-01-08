import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    GridBagLayout grid;
    GridBagConstraints constraints;
    JLabel heading;
    JLabel p1;
    JLabel p2;
    JLabel p3;
    JLabel email;
    About()
    {
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        constraints.insets=new Insets(10,10,10,10);
        setTitle("About");
        setLayout(grid);
        setSize(800,400);

        String str="Virtual Breadboard\n";
        heading=new JLabel(str);
        str="Virtual Breadboard is a project to simulate experiments of Digital Logic Designs\n";
        p1=new JLabel(str);
        str="This project is made by Md Farhan Tanvir , and Nadia Motalib\n\n\n";
        p2=new JLabel(str);
        str="Contact us :\n";
        p3=new JLabel(str);
        String add="farhantanvir.2340.csedu@gmail.com\n";
        email=new JLabel(add);
        email.setForeground(Color.BLUE);

        add(heading);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(heading,constraints);

        add(p1);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(p1,constraints);

        add(p2);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(p2,constraints);

        add(p3);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(p3,constraints);

        add(email);
        constraints.gridx=0;
        constraints.gridy=5;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(email,constraints);

        setVisible(true);
    }
}
