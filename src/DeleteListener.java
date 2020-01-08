import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DeleteListener implements ActionListener {

    Data data;
    JFrame deleteWindow;
    GridBagLayout grid;
    GridBagConstraints constraints;
    String str;
    String fileName;
    JButton delete;
    JRadioButton files[];
    String fileList[];
    int len;
    DeleteListener(Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        deleteWindow=new JFrame();
        deleteWindow.setTitle("Open Window");
        deleteWindow.setSize(500,500);
        deleteWindow.setLayout(grid);

        str=data.dir;
        File fileDir=new File(str);
        fileList=fileDir.list();
        len=fileList.length;
        files=new JRadioButton[len];
        ButtonGroup bg=new ButtonGroup();
        for(int i=0;i<len;i++)
        {
            files[i]=new JRadioButton(fileList[i]);
            deleteWindow.add(files[i]);
            bg.add(files[i]);
            constraints.gridx=0;
            constraints.gridy=i;
            constraints.anchor=GridBagConstraints.WEST;
            grid.setConstraints(files[i],constraints);
        }
        delete=new JButton("Delete");
        deleteWindow.add(delete);
        constraints.gridx=0;
        constraints.gridy=len;
        constraints.anchor=GridBagConstraints.WEST;
        grid.setConstraints(delete,constraints);

        deleteWindow.setVisible(true);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<len;i++)
                {
                    if(files[i].isSelected())
                    {
                        fileName=str+"/"+fileList[i];
                        File file = new File(fileName);
                        String[]entries = file.list();
                        for(String s: entries)
                        {
                            File currentFile = new File(file.getPath(),s);
                            currentFile.delete();
                        }
                        file.delete();
                        break;
                    }
                }
                deleteWindow.dispose();
            }
        });

    }
}
