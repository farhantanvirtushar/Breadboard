import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFileListener implements ActionListener {

    Data data;
    JTextField fileNameField;
    JButton save;
    JLabel jLabel;
    JFrame saveWindow;
    GridBagLayout grid;
    GridBagConstraints constraints;
    SaveFileListener (Data data)
    {
        this.data=data;
        grid=new GridBagLayout();
        constraints=new GridBagConstraints();
        fileNameField=new JTextField(30);
        jLabel=new JLabel("Enter file name");
        save=new JButton("save");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        saveWindow=new JFrame();
        saveWindow.setTitle("Save");
        saveWindow.setSize(600,200);
        saveWindow.setLayout(grid);
        constraints.insets=new Insets(10,10,10,10);

        saveWindow.add(fileNameField);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(fileNameField,constraints);

        saveWindow.add(jLabel);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(jLabel,constraints);

        saveWindow.add(save);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.anchor=GridBagConstraints.CENTER;
        grid.setConstraints(save,constraints);

        saveWindow.setVisible(true);

        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String str=fileNameField.getText();
                SaveFile saveFile=new SaveFile(data,str);
                boolean fileAlreadyExists=saveFile.exists();
                if(fileAlreadyExists)
                {
                    jLabel.setText("File Already Exists. Choose A Different Name");
                    return ;
                }
                saveFile.save();
                jLabel.setText("Enter file name");
                saveWindow.dispose();
            }
        });
    }
}
