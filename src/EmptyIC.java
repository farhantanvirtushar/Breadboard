public class EmptyIC  extends ICfamily{

    EmptyIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="empty";
    }
    @Override
    void operate() {

    }
    void clear()
    {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        for(int i=2;i<=7;i++)
        {
            data.cellValue[a+i]=0;
            data.dfsDisconnection(a+i);
            data.resetCellColorDisconnection();
        }
        for(int i=2;i<=7;i++)
        {
            data.cellValue[b+i]=0;
            data.dfsDisconnection(b+i);
            data.resetCellColorDisconnection();
        }
    }
}
