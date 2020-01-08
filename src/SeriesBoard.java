import javax.swing.*;
import java.awt.*;

public class SeriesBoard extends JPanel {

    GridLayout gridLayout;
    int COLUMN;
    int ROW;
    int n;
    Data data;
    JRadioButton cell[][];
    SeriesBoard(Data data,int n)
    {
        this.n=n;
        this.data=data;
        this.COLUMN=data.COLUMN;
        this.ROW=2;
        gridLayout=new GridLayout(ROW,COLUMN);
        setLayout(gridLayout);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cell=new JRadioButton[ROW][COLUMN];
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COLUMN;j++)
            {
                cell[i][j]=new JRadioButton();
                cell[i][j].setActionCommand(data.CELL+" "+((COLUMN*2)+10+i+(n*ROW))+" "+j);
                cell[i][j].addActionListener(new CellListener(data));

                cell[i][j].setBackground(Color.LIGHT_GRAY);
                add(cell[i][j]);
            }
        }
    }
}