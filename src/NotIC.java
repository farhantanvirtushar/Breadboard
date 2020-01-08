public class NotIC extends ICfamily{

    NotIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="not";
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        not(a+2,a+3);
        not(a+4,a+5);
        not(a+6,a+7);
        not(b+2,b+3);
        not(b+4,b+5);
        not(b+6,b+7);
    }
    void not(int i,int o)
    {
        int x=data.cellValue[i];
        int out;
        out=1-x;
        data.cellValue[o]=out;
        data.dfs(o);
        data.resetCellColor();
    }
}
