public class Timer implements Runnable{

    Data data;
    Thread t;
    Permission permission;
    int sec;
    Timer(Data data,Permission permission)
    {
        this.data=data;
        this.permission=permission;
        sec=0;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        try {
            while (true)
            {
                permission.timeCount();
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
