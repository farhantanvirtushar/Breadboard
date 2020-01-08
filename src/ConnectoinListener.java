import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectoinListener implements ActionListener {

    Data data;
    ConnectoinListener(Data data)
    {
        this.data=data;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String str=actionEvent.getActionCommand();
        if(str.equals("Connect"))
        {
            data.connect=true;
        }
        else
        {
            data.connect=false;
        }
        //System.out.println(data.connect);
    }
}
