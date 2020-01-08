import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.Scanner;

public class CellListener implements ActionListener {

    Data data;
    CellListener(Data data)
    {
        this.data=data;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        JRadioButton jRadioButton=(JRadioButton)actionEvent.getSource();
        data.link(jRadioButton);
        StringReader stringReader=new StringReader(jRadioButton.getActionCommand());
        Scanner k=new Scanner(stringReader);
        int cellType=k.nextInt();
        int col=k.nextInt();
        if(data.connect)
        {
            data.type[data.connection]=cellType;
            data.column[data.connection]=col;
            data.connection++;
            if(data.connection==2)
            {
                data.connection=0;
                data.makeConnection();
                data.type=new int[2];
                data.column=new int[2];
            }
        }
        else
        {
            data.type[data.disconnection]=cellType;
            data.column[data.disconnection]=col;
            data.disconnection++;
            if(data.disconnection==2)
            {
                data.disconnection=0;
                data.makeDisconnection();
                data.type=new int[2];
                data.column=new int[2];
            }
        }
    }

}