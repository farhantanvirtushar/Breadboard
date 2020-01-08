import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SaveFile {

    Data data;
    String fileName;
    File file;
    String fileDir;
    SaveFile(Data data,String fileName)
    {
        this.data=data;
        this.fileName=fileName;
        file=new File(data.dir+"/"+fileName);
        fileDir=data.dir+"/"+fileName+"/";
    }
    boolean exists()
    {
        if(!file.exists())
        {
            file.mkdir();
            return false;
        }
        return true;
    }
    void save()
    {
        try{
            File switchConnectionFile=new File(fileDir+"switchConnection.txt");
            File breadBoardConnectionFile=new File(fileDir+"breadBoardConnection.txt");
            File mapFile=new File(fileDir+"map.txt");
            File icFile=new File(fileDir+"ic.txt");
            PrintStream printSwitchConn=new PrintStream(new FileOutputStream(switchConnectionFile));
            PrintStream bBoardConn=new PrintStream(new FileOutputStream(breadBoardConnectionFile));
            PrintStream map=new PrintStream(new FileOutputStream(mapFile));
            PrintStream ic=new PrintStream(new FileOutputStream(icFile));

            for(int i=0;i<114;i++)
            {
                for(int j=0;j<114;j++)
                {
                    int x=data.breadboardConnection[i][j];
                    if(x>0)
                    {
                        bBoardConn.println(i+" "+j+" "+x);
                    }

                }
            }
            for(int i=0;i<12;i++)
            {
                printSwitchConn.println(data.switchConnection[i]);
            }
            for ( JComponent c1 : data.linker.linked.keySet () )
            {
                JComponent c2=data.linker.linked.get(c1);
                map.println(((JRadioButton)c1).getActionCommand() + " "+((JRadioButton)c2).getActionCommand());

            }
            for(int i=0;i<5;i++)
            {
                ic.println(data.iCinfo.ICList[i].name);
            }
        }catch (Exception e)
        {

        }

    }
}
