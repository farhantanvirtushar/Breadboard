import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.Scanner;

public class LeftBoard extends JPanel {

    GridBagLayout grid;
    GridBagConstraints constraints;
    Data data;
    JRadioButton ve;
    JRadioButton zeroVolt;
    JRadioButton f;
    JLabel hz;
    JTextField inputfreq;

    LeftBoard(Data data)
    {
        this.data=data;
        hz=new JLabel();
        hz.setText("Hz");
        inputfreq=new JTextField(((float)(1.0/data.timePeriod))+"",5);
        hz.setForeground(Color.BLUE);
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        setLayout(grid);
        constraints.insets=new Insets(10,0,10,0);

        ImageIcon icon1=new ImageIcon(getClass().getResource("/imageAndIcon/5v.png"));
        Image scaleImage1 = icon1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(getClass().getResource("/imageAndIcon/ground.png"));
        Image scaleImage2 = icon2.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(getClass().getResource("/imageAndIcon/squareWave.png"));
        Image scaleImage3 = icon3.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon icon4=new ImageIcon(getClass().getResource("/imageAndIcon/plus.png"));
        Image scaleImage4 = icon4.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
        ImageIcon icon5=new ImageIcon(getClass().getResource("/imageAndIcon/minus.png"));
        Image scaleImage5 = icon5.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);

        ImageIcon voltageSource=new ImageIcon(scaleImage1);
        ImageIcon ground=new ImageIcon(scaleImage2);
        ImageIcon sqWave=new ImageIcon(scaleImage3);
        ImageIcon plus=new ImageIcon(scaleImage4);
        ImageIcon minus=new ImageIcon(scaleImage5);

        ButtonGroup bg=new ButtonGroup();
        JRadioButton connectWire=new JRadioButton("Connect");
        connectWire.addActionListener(new ConnectoinListener(data));
        connectWire.setSelected(true);
        add(connectWire);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(connectWire, constraints);

        JRadioButton disconnectWire=new JRadioButton("Disconnect");
        disconnectWire.addActionListener(new ConnectoinListener(data));
        add(disconnectWire);
        bg.add(connectWire);
        bg.add(disconnectWire);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(disconnectWire, constraints);

        JButton vsource=new JButton(voltageSource);
        vsource.setBackground(Color.WHITE);
        vsource.setSize(50,50);
        add(vsource);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(vsource, constraints);

        ve=new JRadioButton();
        ve.setActionCommand(data.SWITCH+" "+10+" "+0);
        ve.addActionListener(new CellListener(data));
        add(ve);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(ve, constraints);

        JButton groundsource=new JButton(ground);
        groundsource.setBackground(Color.WHITE);
        groundsource.setSize(50,50);
        add(groundsource);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(groundsource, constraints);

        zeroVolt=new JRadioButton();
        zeroVolt.setActionCommand(data.SWITCH+" "+12+" "+0);
        zeroVolt.addActionListener(new CellListener(data));
        add(zeroVolt);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(zeroVolt, constraints);

        JButton freq=new JButton(sqWave);
        freq.setBackground(Color.WHITE);
        add(freq);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(freq, constraints);

        f=new JRadioButton();
        f.setActionCommand(data.SWITCH+" "+11+" "+0);
        f.addActionListener(new CellListener(data));
        add(f);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(f, constraints);

        add(inputfreq);
        constraints.gridx=0;
        constraints.gridy=5;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(inputfreq,constraints);

        add(hz);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(hz, constraints);

        inputfreq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String str = inputfreq.getText();
                char c[]=str.toCharArray();
                boolean b=true;
                if(isNotNumber(c))
                {
                    b=false;
                }
                if(b)
                {
                    StringReader stringReader=new StringReader(str);
                    Scanner k=new Scanner(stringReader);
                    double fq=k.nextDouble();
                    data.timePeriod=(1.0/fq);
                    data.setTime();
                }
                String s=(((float)(1.0/data.timePeriod))+"");
                inputfreq.setText(s);
            }
        });

    }

    boolean isNotNumber(char c[])
    {
        int count=0;
        for(int i=0;i<c.length;i++)
        {
            if(!((c[i]>='0')&&(c[i]<='9')))
            {
                if(c[i]=='.')
                {
                    count++;
                }
                else if(c[i]!='.')
                {
                    return true;
                }
            }
            if(count>1)
            {
                return true;
            }
        }
        return false;
    }
}