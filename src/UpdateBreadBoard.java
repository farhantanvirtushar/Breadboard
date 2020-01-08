public class UpdateBreadBoard implements Runnable{

    Data data;
    Thread t;
    Permission permission;
    UpdateBreadBoard(Data data,Permission permission)
    {
        this.data=data;
        this.permission=permission;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while(true)
        {
            try {

                permission.updateBreadboard();

            }catch (Exception e)
            {
                System.out.println(e);
            }
            //permission.permit();
        }
    }
}
