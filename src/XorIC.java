public class XorIC extends ICfamily{

    XorIC(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="xor";
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        xor(a+2,a+3,a+4);
        xor(a+5,a+6,a+7);
        xor(b+2,b+3,b+4);
        xor(b+5,b+6,b+7);
    }
    void xor(int i1,int i2,int o)
    {
        int x=data.cellValue[i1];
        int y=data.cellValue[i2];
        int out;
        if((x==0)&&(y==0))
        {
            out=0;
        }
        else if((x==1)&&(y==1))
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
