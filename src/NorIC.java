public class NorIC extends ICfamily{

    NorIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="nor";
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        nor(a+2,a+3,a+4);
        nor(a+5,a+6,a+7);
        nor(b+2,b+3,b+4);
        nor(b+5,b+6,b+7);
    }
    void nor(int i1,int i2,int o)
    {
        int x=data.cellValue[i1];
        int y=data.cellValue[i2];
        int out;
        if((x==0)&&(y==0))
        {
            out=1;
        }
        else
        {
            out=0;
        }
        data.cellValue[o]=out;
        data.dfs(o);
        data.resetCellColor();
    }
}
