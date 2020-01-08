import javax.swing.*;
import java.awt.*;

public class ICinfo {

    Data data;

    ICfamily ICList[];
    String dir;
    ImageIcon imageIcon;
    Image scaleImage;

    ImageIcon emptyIC;
    ImageIcon andIC;
    ImageIcon orIC;
    ImageIcon notIC;
    ImageIcon nandIC;
    ImageIcon norIC;
    ImageIcon xorIC;
    ImageIcon xnorIC;
    ImageIcon jkFFIC;

    ICinfo(Data data)
    {
        this.data=data;
        ICList=new ICfamily[5];
        for(int i=0;i<5;i++)
        {
            ICList[i]=new EmptyIC(data,i);
        }

        dir = System.getProperty("user.dir");

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/emptyIC.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        emptyIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/and.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        andIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/or.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        orIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/not.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        notIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/nand.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        nandIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/nor.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        norIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/xor.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        xorIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/xnor.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        xnorIC=new ImageIcon(scaleImage);

        imageIcon=new ImageIcon(getClass().getResource("/imageAndIcon/JK-FF.png"));
        scaleImage = imageIcon.getImage().getScaledInstance(120, 70,Image.SCALE_DEFAULT);
        jkFFIC=new ImageIcon(scaleImage);
    }
    void operate()
    {
        for(int i=0;i<5;i++)
        {
            ICList[i].operate();
        }
    }
}