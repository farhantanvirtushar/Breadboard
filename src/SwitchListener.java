import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.StringReader;
import java.util.Scanner;

public class SwitchListener implements ItemListener {

    Data data;
    ImageIcon on;
    ImageIcon off;
    SwitchListener(ImageIcon on,ImageIcon off,Data data)
    {
        this.data=data;
        this.on=on;
        this.off=off;
    }
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        JToggleButton jToggleButton=(JToggleButton)itemEvent.getItem();
        int indx=getIndx(jToggleButton.getActionCommand());
        if(jToggleButton.isSelected())
        {
            jToggleButton.setIcon(on);
            data.switchValue[indx]=1;
            //show();
        }
        else
        {
            jToggleButton.setIcon(off);
            data.switchValue[indx]=0;
            //show();
        }
    }
    void show()
    {
        data.showSwitch();
    }
    int getIndx(String str)
    {
        StringReader stringReader=new StringReader(str);
        Scanner k=new Scanner(stringReader);
        return k.nextInt();
    }
}
