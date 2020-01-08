public class JKflipflop extends ICfamily{

    int cpVal1[];
    int cpVal2[];
    int i;

    JKflipflop(Data data,int IcNo)
    {
        this.data=data;
        this.IcNo=IcNo;
        name="JK-FF";
        cpVal1=new int[2];
        cpVal2=new int[2];
        cpVal1[0]=0;
        cpVal1[1]=0;
        cpVal2[0]=0;
        cpVal2[1]=0;
        i=0;
    }

    @Override
    void operate() {
        int a=(10*IcNo);
        int b=a+data.COLUMN;
        cpVal1[0]=cpVal1[1];
        cpVal2[0]=cpVal2[1];
        cpVal1[1]=data.cellValue[a+2];
        cpVal2[1]=data.cellValue[b+2];

        int cp1=0;
        int cp2=0;
        if((cpVal1[0]==1)&&(cpVal1[1]==0))
        {

            cp1=1;
        }
        if((cpVal2[0]==1)&&(cpVal2[1]==0))
        {
            cp2=1;
        }
        ff(cp1,a+3,a+4,a+5,a+6);
        ff(cp2,b+3,b+4,b+5,b+6);

    }
    void ff(int i1,int i2,int i3,int o1,int o2)
    {
        int cp=i1;
        int j=data.cellValue[i2];
        int k=data.cellValue[i3];
        int q,qbar;
        q=data.cellValue[o1];
        qbar=1-q;
        if(cp==1)
        {
            if((j==1)&&(k==1))
            {
                q=1-q;
            }
            else if((j==1)&&(k==0))
            {
                q=1;
            }
            else if((j==0)&&(k==1))
            {
                q=0;
            }
            qbar=1-q;
        }
        data.cellValue[o1]=q;
        data.dfs(o1);
        data.resetCellColor();
        data.cellValue[o2]=qbar;
        data.dfs(o2);
        data.resetCellColor();
    }
}