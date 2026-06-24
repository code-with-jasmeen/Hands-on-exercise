package SingletonPatternExample;

public class SingletonTest
{
    public static void main(String[] args)
    {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Hello Cognizant");
        l2.log("Same instance test");

        System.out.println("Both are same object? " + (l1 == l2));
    }
}
