import javax.swing.*;
import java.awt.*;

public class BreadBoard extends JFrame{

    Data data;
    CenterBoard centerBoard;
    Topmenu topmenu;
    LeftBoard leftBoard;
    Permission permission;
    BreadBoard()
    {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        setLayout(new BorderLayout());
        setTitle("Virtual Bread Board");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Linker linker=new Linker();
        setGlassPane(linker);
        linker.setVisible ( true );
        data=new Data(linker,this);
        centerBoard = new CenterBoard(data);
        topmenu=new Topmenu(data);
        leftBoard=new LeftBoard(data);
        add(centerBoard,BorderLayout.CENTER);
        add(topmenu,BorderLayout.NORTH);
        add(leftBoard,BorderLayout.WEST);

        permission=new Permission(data);
        new UpdateBreadBoard(data,permission);
        new Timer(data,permission);
        setVisible(true);

    }
}