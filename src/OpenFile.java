import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class OpenFile {

    Data data;
    String fileDir;
    OpenFile(Data data,String fileDir)
    {
        this.data=data;
        this.fileDir=fileDir;

        File switchConnectionFile=new File(fileDir+"switchConnection.txt");
        File breadBoardConnectionFile=new File(fileDir+"breadBoardConnection.txt");
        File mapFile=new File(fileDir+"map.txt");
        File icFile=new File(fileDir+"ic.txt");

        try{

            Scanner switchConn=new Scanner(new FileInputStream(switchConnectionFile));
            BufferedReader map=new BufferedReader(new FileReader(mapFile));
            BufferedReader bBoardConn=new BufferedReader(new FileReader(breadBoardConnectionFile));
            Scanner ic=new Scanner(new FileInputStream(icFile));

            data.clear();

            for(int i=0;i<12;i++)
            {
                data.switchConnection[i]=switchConn.nextInt();
            }
            String connection;
            while ((connection=bBoardConn.readLine())!=null)
            {
                StringReader stringReader=new StringReader(connection);
                Scanner bBoardIn=new Scanner(stringReader);
                int i=bBoardIn.nextInt();
                int j=bBoardIn.nextInt();
                int val=bBoardIn.nextInt();
                data.breadboardConnection[i][j]=val;

            }
            for(int i=0;i<5;i++)
            {
                String str=ic.nextLine();
                if(str.equals("and"))
                {
                    data.ic[i].setIcon(data.iCinfo.andIC);
                    data.iCinfo.ICList[i]=new AndIC(data,i);
                }
                else if(str.equals("or"))
                {
                    data.ic[i].setIcon(data.iCinfo.orIC);
                    data.iCinfo.ICList[i]=new OrIC(data,i);
                }
                else if(str.equals("not"))
                {
                    data.ic[i].setIcon(data.iCinfo.notIC);
                    data.iCinfo.ICList[i]=new NotIC(data,i);
                }
                else if(str.equals("nand"))
                {
                    data.ic[i].setIcon(data.iCinfo.nandIC);
                    data.iCinfo.ICList[i]=new NandIC(data,i);
                }
                else if(str.equals("nor"))
                {
                    data.ic[i].setIcon(data.iCinfo.norIC);
                    data.iCinfo.ICList[i]=new NorIC(data,i);
                }
                else if(str.equals("xor"))
                {
                    data.ic[i].setIcon(data.iCinfo.xorIC);
                    data.iCinfo.ICList[i]=new XorIC(data,i);
                }
                else if(str.equals("xnor"))
                {
                    data.ic[i].setIcon(data.iCinfo.xnorIC);
                    data.iCinfo.ICList[i]=new XnorIC(data,i);
                }
                else if(str.equals("JK-FF"))
                {
                    data.ic[i].setIcon(data.iCinfo.jkFFIC);
                    data.iCinfo.ICList[i]=new JKflipflop(data,i);
                }
                else if(str.equals("none"))
                {
                    data.ic[i].setIcon(data.iCinfo.emptyIC);
                    data.iCinfo.ICList[i]=new EmptyIC(data,i);
                    data.iCinfo.ICList[i].clear();
                }
            }

            String str;
            while ((str=map.readLine())!=null)
            {
                StringReader stringReader=new StringReader(str);
                int type1,col1,row1,type2,col2,row2;
                Scanner mapInput=new Scanner(stringReader);
                type1=mapInput.nextInt();
                col1=mapInput.nextInt();
                row1=mapInput.nextInt();
                type2=mapInput.nextInt();
                col2=mapInput.nextInt();
                row2=mapInput.nextInt();

                JComponent c1,c2;
                c1=getComponent(type1,col1,row1);
                c2=getComponent(type2,col2,row2);
                data.link(c1);
                data.link(c2);
            }

        }
        catch (Exception e)
        {

        }

    }

    JComponent getComponent(int type,int col,int row)
    {
        JComponent c=new JRadioButton();
        if(type==data.SWITCH)
        {
            if((col>=0)&&(col<=9))
            {
                c=data.breadBoard.centerBoard.onOffswitch.inputTerminal[col];
            }
            else if(col==10)
            {
                c=data.breadBoard.leftBoard.ve;
            }
            else if(col==11)
            {
                c=data.breadBoard.leftBoard.f;
            }
            else if(col==12)
            {
                c=data.breadBoard.leftBoard.zeroVolt;
            }
        }
        else if(type==data.CELL)
        {
            if((col>=0)&&(col<=49))
            {
                c=data.breadBoard.centerBoard.bottomBoard.cell[row][col];
            }
            else if((col>=50)&&(col<=99))
            {
                c=data.breadBoard.centerBoard.topBoard.cell[row][col-data.COLUMN];
            }
            else if((col>=100)&&(col<=109))
            {
                c=data.breadBoard.centerBoard.led.inputTerminal[col-100];
            }
            else if((col>=110)&&(col<=111))
            {
                c=data.breadBoard.centerBoard.bottomSeriesBoard.cell[col-((data.COLUMN*2)+10)][row];
            }
            else if((col>=112)&&(col<=113))
            {
                c=data.breadBoard.centerBoard.topSeriesBoard.cell[col-((data.COLUMN*2)+10+2)][row];
            }
        }
        return c;
    }
}
