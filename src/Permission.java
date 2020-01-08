public class Permission{

    boolean clock;
    boolean updater;
    Data data;
    int sec;
    Permission(Data data)
    {
        clock=true;
        updater=false;
        this.data=data;
        sec=0;
    }

    synchronized void timeCount()throws Exception
    {
        while (!clock)
        {
            wait();
        }
        Thread.sleep(1);
        sec++;
        if(sec>(data.sleepingTime/2))
        {
            sec=0;
            data.switchValue[11]=1-data.switchValue[11];
            int root=data.switchConnection[11];
            if(root!=-1)
            {
                data.cellValue[root]=data.switchValue[11];
                data.dfs(root);
                data.resetCellColor();
                data.update();
            }
        }
        clock=false;
        updater=true;
        notify();
        wait();
    }
    synchronized void updateBreadboard()throws Exception
    {
        while (!updater)
        {
            wait();
        }
        data.update();
        clock=true;
        updater=false;
        notify();
        wait();
    }
}
