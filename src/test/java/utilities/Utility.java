package utilities;

public class Utility {

    public static void hardWait(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e){}
    }
}
