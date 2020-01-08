public class XnorIC extends ICfamily{

    XnorIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="xnor";
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        xnor(a+2,a+3,a+4);
        xnor(a+5,a+6,a+7);
        xnor(b+2,b+3,b+4);
        xnor(b+5,b+6,b+7);
    }
    void xnor(int i1,int i2,int o)
    {
        int x=data.cellValue[i1];
        int y=data.cellValue[i2];
        int out;
        if((x==0)&&(y==0))
        {
            out=1;
        }
        else if((x==1)&&(y==1))
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
