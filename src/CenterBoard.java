import javax.swing.*;
import java.awt.*;

public class CenterBoard extends JPanel {

    Data data;
    GridBagLayout grid;
    GridBagConstraints constraints;
    LED led;
    SeriesBoard topSeriesBoard;
    SeriesBoard bottomSeriesBoard;
    Board topBoard;
    IC ic;
    Board bottomBoard;
    Switch onOffswitch;

    CenterBoard(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        setLayout(grid);

        led=new LED(data);
        add(led);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(led,constraints);

        constraints.insets=new Insets(10,10,10,10);

        topSeriesBoard = new SeriesBoard(data,1);
        add(topSeriesBoard);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.anchor=GridBagConstraints.NORTH;
        grid.setConstraints(topSeriesBoard,constraints);

        constraints.insets=new Insets(0,0,0,0);

        topBoard =new Board(data,1);
        add(topBoard);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(topBoard,constraints);

        ic =new IC(data);
        add(ic);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(ic,constraints);



        bottomBoard =new Board(data,0);
        add(bottomBoard);
        constraints.gridx=0;
        constraints.gridy=5;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(bottomBoard,constraints);

        constraints.insets=new Insets(10,10,10,10);

        bottomSeriesBoard = new SeriesBoard(data,0);
        add(bottomSeriesBoard) ;
        constraints.gridx=0;
        constraints.gridy=7;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(bottomSeriesBoard ,constraints);

        constraints.insets=new Insets(0,0,0,0);

        onOffswitch =new Switch(data);
        add(onOffswitch);
        constraints.gridx=0;
        constraints.gridy=8;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(onOffswitch,constraints);
    }

}
