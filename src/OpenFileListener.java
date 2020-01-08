import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenFileListener implements ActionListener {

    Data data;
    JFrame openWindow;
    GridBagLayout grid;
    GridBagConstraints constraints;
    String str;
    String fileName;
    JButton open;
    JRadioButton files[];
    String fileList[];
    int len;
    OpenFileListener(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        openWindow=new JFrame();
        openWindow.setTitle("Open Window");
        openWindow.setSize(500,500);
        openWindow.setLayout(grid);

        str=data.dir;
        File fileDir=new File(str);
        fileList=fileDir.list();
        len=fileList.length;
        files=new JRadioButton[len];
        ButtonGroup bg=new ButtonGroup();
        for(int i=0;i<len;i++)
        {
            files[i]=new JRadioButton(fileList[i]);
            openWindow.add(files[i]);
            bg.add(files[i]);
            constraints.gridx=0;
            constraints.gridy=i;
            constraints.anchor=GridBagConstraints.WEST;
            grid.setConstraints(files[i],constraints);
        }
        open=new JButton("Open");
        openWindow.add(open);
        constraints.gridx=0;
        constraints.gridy=len;
        constraints.anchor=GridBagConstraints.WEST;
        grid.setConstraints(open,constraints);

        openWindow.setVisible(true);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<len;i++)
                {
                    if(files[i].isSelected())
                    {
                        fileName=str+"/"+fileList[i]+"/";
                        new OpenFile(data,fileName);
                        break;
                    }
                }
                openWindow.dispose();
            }
        });

    }
}
