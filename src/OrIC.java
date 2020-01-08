public class OrIC extends ICfamily{

    OrIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="or";
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        or(a+2,a+3,a+4);
        or(a+5,a+6,a+7);
        or(b+2,b+3,b+4);
        or(b+5,b+6,b+7);
    }
    void or(int i1,int i2,int o)
    {
        int x=data.cellValue[i1];
        int y=data.cellValue[i2];
        int out;
        if((x==0)&&(y==0))
        {
            out=0;
        }
        else
        {
            out=1;
        }
        data.cellValue[o]=out;
        data.dfs(o);
        data.resetCellColor();
    }
}
