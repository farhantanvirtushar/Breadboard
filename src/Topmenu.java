import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Topmenu extends JPanel {

    Data data;
    FlowLayout flowLayout;
    Button FILE;
    Button IC;
    Button Wire;
    Button Help;
    Button Clear;
    Button Exit;
    Topmenu(Data data)
    {
        this.data=data;
        flowLayout=new FlowLayout();
        setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        JMenuBar menuBar=new JMenuBar();

        JMenu mfile=new JMenu("File");
        JMenuItem open=new JMenuItem("Open");
        JMenuItem save=new JMenuItem("Save");
        JMenuItem delete=new JMenuItem("Delete Saved Circuit");

        mfile.add(open);
        mfile.add(save);
        mfile.add(delete);

        menuBar.add(mfile);

        JMenu mClear=new JMenu("Clear");
        JMenuItem clear=new JMenuItem("Clear");
        mClear.add(clear);
        menuBar.add(mClear);

        JMenu mHelp=new JMenu("Help");
        JMenuItem howToUse=new JMenuItem("How To Use");
        JMenuItem about=new JMenuItem("About");
        mHelp.add(howToUse);
        mHelp.add(about);
        menuBar.add(mHelp);

        JMenu mExit=new JMenu("Exit");
        JMenuItem exit=new JMenuItem("Exit");
        mExit.add(exit);
        menuBar.add(mExit);

        add(menuBar);

        save.addActionListener(new SaveFileListener(data));
        open.addActionListener(new OpenFileListener(data));
        delete.addActionListener(new DeleteListener(data));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                data.clear();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        howToUse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new HelpMenu(data);
            }
        });
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new About();
            }
        });

    }
}
