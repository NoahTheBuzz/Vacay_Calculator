package nrn.noah.priv;


public class App 
{
    public static void main( String[] args )
    {
        Runnable r = () -> System.out.println("Lambda expression working!");
        r.run();
    }
}
