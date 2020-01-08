import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

public class Data{
    double timePeriod;
    int sleepingTime;
    BreadBoard breadBoard;
    final int SWITCH=1;
    final int CELL=2;
    boolean stop;
    Linker linker;
    final int WHITE=1;
    final int BLACK=2;
    final int GRAY=3;
    final int ROW=5;
    final int COLUMN=50;
    int cellValue[];
    int cellColor[];
    int cellColorDisconnection[];
    int switchValue[];
    boolean connect;
    int switchConnection[];
    int breadboardConnection[][];
    JButton light[];
    JToggleButton onOff[];
    String dir;
    int connection;
    int disconnection;
    int lineConnection;
    int type[];
    int column[];
    Point point[];
    ImageIcon onBulb;
    ImageIcon offBulb;
    ImageIcon on;
    ImageIcon off;
    JComponent last;
    File savedCircuit;
    JButton ic[];

    ICinfo iCinfo;
    Data(Linker linker,BreadBoard breadBoard)
    {
        timePeriod=1.0;
        sleepingTime=1000;
        this.breadBoard=breadBoard;
        stop=false;
        ic=new JButton[5];
        //IC info
        iCinfo=new ICinfo(this);

        //IC info
        last=null;
        this.linker=linker;
        cellValue=new int[(COLUMN*2)+10+4];
        for(int i=0;i<cellValue.length;i++)
        {
            cellValue[i]=0;
        }
        switchValue=new int[13];
        for(int i=0;i<10;i++)
        {
            switchValue[i]=0;
        }
        switchValue[10]=1;
        switchValue[11]=0;
        switchValue[12]=0;
        connect=true;
        switchConnection=new int[13];
        for(int i=0;i<13;i++)
        {
            switchConnection[i]=-1;
        }
        breadboardConnection=new int [(COLUMN*2)+10+4][(COLUMN*2)+10+4];

        int l=(COLUMN*2)+10+4;
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l;j++)
            {
                breadboardConnection[i][j]=0;
            }
       }
        lineConnection=0;
        connection=0;
        disconnection=0;
        type=new int[2];
        column=new int[2];
        point=new Point[2];
        light=new JButton[10];

        dir = System.getProperty("user.dir");
        savedCircuit=new File(dir+"/savedCircuits/");
        if(!savedCircuit.exists())
        {
            savedCircuit.mkdir();
        }
        dir+="/savedCircuits";
        ImageIcon icon1=new ImageIcon(getClass().getResource("imageAndIcon/onBulb.png"));
        Image scaleImage1 = icon1.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(getClass().getResource("imageAndIcon/offBulb.png"));
        Image scaleImage2 = icon2.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT);

        onBulb=new ImageIcon(scaleImage1);
        offBulb=new ImageIcon(scaleImage2);
        cellColor=new int[(COLUMN*2)+10+4];
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColor[i]=WHITE;
        }
        cellColorDisconnection=new int[(COLUMN*2)+10+4];
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColorDisconnection[i]=WHITE;
        }
    }
    void setTime()
    {
        sleepingTime=(int)(timePeriod*1000);
    }
    void showSwitch()
    {
        for(int i=0;i<switchValue.length;i++)
        {
            System.out.print(switchValue[i]+" ");
        }
        System.out.println();
    }
    void makeConnection()
    {
        if((type[0]==SWITCH)||(type[1]==SWITCH))
        {
            if(!((type[0]==SWITCH)&&(type[1]==SWITCH)))
            {
                if(type[0]==SWITCH)
                {
                    switchConnection[column[0]]=column[1];
                }
                else if(type[1]==SWITCH)
                {
                    switchConnection[column[1]]=column[0];
                }
            }
        }
        else
        {
            int u=column[0];
            int v=column[1];
            if(u!=v)
            {
                breadboardConnection[u][v]++;
                breadboardConnection[v][u]++;
            }
        }
    }
    void makeDisconnection()
    {
        if((type[0]==SWITCH)||(type[1]==SWITCH))
        {
            if(!((type[0]==SWITCH)&&(type[1]==SWITCH)))
            {
                if(type[0]==SWITCH)
                {
                    switchConnection[column[0]]=-1;
                    cellValue[column[1]]=0;
                    dfsDisconnection(column[1]);
                    resetCellColorDisconnection();
                }
                else if(type[1]==SWITCH)
                {
                    switchConnection[column[1]]=-1;
                    cellValue[column[0]]=0;
                    dfsDisconnection(column[0]);
                    resetCellColorDisconnection();
                }
            }
        }
        else
        {
            int u=column[0];
            int v=column[1];
            if(u!=v)
            {
                if(breadboardConnection[u][v]>0)
                {
                    breadboardConnection[u][v]--;
                    breadboardConnection[v][u]--;
                    if(breadboardConnection[u][v]==0)
                    {
                        cellValue[u]=0;
                        dfsDisconnection(u);
                        resetCellColorDisconnection();
                        cellValue[v]=0;
                        dfsDisconnection(v);
                        resetCellColorDisconnection();
                    }
                }
            }
        }
    }
    void resetCellColor()
    {
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColor[i]=WHITE;
        }
    }
    void resetCellColorDisconnection()
    {
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColorDisconnection[i]=WHITE;
        }
    }
   void update()
    {

        for(int i=0;i<13;i++)
        {
            if((switchConnection[i]!=-1)&&(i!=11))
            {
                int root=switchConnection[i];
                cellValue[root]=switchValue[i];
                dfs(root);
                resetCellColor();
            }

        }
        operateIC();
        updateLights();
    }
    void updateLights()
    {
        for(int i=100;i<110;i++)
        {
            if(cellValue[i]==1)
            {
                light[i-100].setIcon(onBulb);
            }
            else
            {
                light[i-100].setIcon(offBulb);
            }
        }
    }
    void dfs(int r)
    {
        cellColor[r]=GRAY;
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            if(breadboardConnection[r][i]>0)
            {
                if(cellColor[i]==WHITE)
                {
                    cellValue[i]=cellValue[r];
                    dfs(i);
                }
            }
        }
        cellColor[r]=BLACK;
    }
    void dfsDisconnection(int r)
    {
        cellColorDisconnection[r]=GRAY;
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            if(breadboardConnection[r][i]>0)
            {
                if(cellColorDisconnection[i]==WHITE)
                {
                    cellValue[i]=cellValue[r];
                    dfsDisconnection(i);
                }
            }
        }
        cellColorDisconnection[r]=BLACK;
    }
    void link ( JComponent button )
    {
        if ( last == null )
        {
            last = button;
        }
        else
        {
            linker.link ( last, button ,connect);
            last = null;
        }
    }
    void operateIC()
    {
        iCinfo.operate();
    }
    void clear()
    {
        linker.clear();
        clearSwitch();
        int l=(COLUMN*2)+10+4;
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l;j++)
            {
                breadboardConnection[i][j]=0;
            }
        }
        for(int i=0;i<cellValue.length;i++)
        {
            cellValue[i]=0;
        }
        for(int i=0;i<5;i++)
        {
                ic[i].setIcon(iCinfo.emptyIC);
                iCinfo.ICList[i]=new EmptyIC(this,i);
                iCinfo.ICList[i].clear();
        }
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColor[i]=WHITE;
        }
        for(int i=0;i<(COLUMN*2)+10+4;i++)
        {
            cellColorDisconnection[i]=WHITE;
        }
    }
    void clearSwitch()
    {
        for(int i=0;i<switchConnection.length;i++)
        {
            switchConnection[i]=-1;
        }
    }
}
