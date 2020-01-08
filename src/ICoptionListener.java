import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ICoptionListener implements ActionListener {

    Data data;
    int IcNo;
    ICoptionListener(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JRadioButton jRadioButton=(JRadioButton)actionEvent.getSource();
        String str=jRadioButton.getActionCommand();
        if(str.equals("and"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.andIC);
            data.iCinfo.ICList[IcNo]=new AndIC(data,IcNo);
        }
        else if(str.equals("or"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.orIC);
            data.iCinfo.ICList[IcNo]=new OrIC(data,IcNo);
        }
        else if(str.equals("not"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.notIC);
            data.iCinfo.ICList[IcNo]=new NotIC(data,IcNo);
        }
        else if(str.equals("nand"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.nandIC);
            data.iCinfo.ICList[IcNo]=new NandIC(data,IcNo);
        }
        else if(str.equals("nor"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.norIC);
            data.iCinfo.ICList[IcNo]=new NorIC(data,IcNo);
        }
        else if(str.equals("xor"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.xorIC);
            data.iCinfo.ICList[IcNo]=new XorIC(data,IcNo);
        }
        else if(str.equals("xnor"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.xnorIC);
            data.iCinfo.ICList[IcNo]=new XnorIC(data,IcNo);
        }
        else if(str.equals("JK-FF"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.jkFFIC);
            data.iCinfo.ICList[IcNo]=new JKflipflop(data,IcNo);
        }
        else if(str.equals("none"))
        {
            data.ic[IcNo].setIcon(data.iCinfo.emptyIC);
            data.iCinfo.ICList[IcNo]=new EmptyIC(data,IcNo);
            data.iCinfo.ICList[IcNo].clear();
        }
    }
}
