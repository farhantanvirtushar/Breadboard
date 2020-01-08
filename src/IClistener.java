import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IClistener implements ActionListener {

    Data data;
    int IcNo;
    GridBagLayout grid;
    GridBagConstraints constraints;

    IClistener(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFrame icSelectionWindow=new JFrame();
        icSelectionWindow.setSize(500,500);

        icSelectionWindow.setLayout(grid);

        ButtonGroup buttonGroup=new ButtonGroup();

        JRadioButton emptyGate=new JRadioButton("none");
        emptyGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton andGate=new JRadioButton("and");
        andGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton orGate=new JRadioButton("or");
        orGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton notGate=new JRadioButton("not");
        notGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton nandGate=new JRadioButton("nand");
        nandGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton norGate=new JRadioButton("nor");
        norGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton xorGate=new JRadioButton("xor");
        xorGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton xnorGate=new JRadioButton("xnor");
        xnorGate.addActionListener(new ICoptionListener(data,IcNo));
        JRadioButton jkFF=new JRadioButton("JK-FF");
        jkFF.addActionListener(new ICoptionListener(data,IcNo));

        constraints.gridx = 0;
        constraints.gridy = 1;
        icSelectionWindow.add(emptyGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(emptyGate,constraints);
        buttonGroup.add(emptyGate);

        constraints.gridx = 1;
        constraints.gridy = 1;
        icSelectionWindow.add(andGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(andGate,constraints);
        buttonGroup.add(andGate);

        constraints.gridx = 2;
        constraints.gridy = 1;
        icSelectionWindow.add(orGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(orGate,constraints);
        buttonGroup.add(orGate);

        constraints.gridx = 3;
        constraints.gridy = 1;
        icSelectionWindow.add(notGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(notGate,constraints);
        buttonGroup.add(notGate);

        constraints.gridx = 4;
        constraints.gridy = 1;
        icSelectionWindow.add(nandGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(nandGate,constraints);
        buttonGroup.add(nandGate);

        constraints.gridx = 0;
        constraints.gridy = 2;
        icSelectionWindow.add(norGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(norGate,constraints);
        buttonGroup.add(norGate);

        constraints.gridx = 1;
        constraints.gridy = 2;
        icSelectionWindow.add(xorGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(xorGate,constraints);
        buttonGroup.add(xorGate);

        constraints.gridx = 2;
        constraints.gridy = 2;
        icSelectionWindow.add(xnorGate);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(xnorGate,constraints);
        buttonGroup.add(xnorGate);

        constraints.gridx = 3;
        constraints.gridy = 2;
        icSelectionWindow.add(jkFF);
        constraints.ipadx=10;
        constraints.ipady=10;
        constraints.anchor = GridBagConstraints.CENTER;
        grid.setConstraints(jkFF,constraints);
        buttonGroup.add(jkFF);

        icSelectionWindow.setVisible(true);
    }
}
