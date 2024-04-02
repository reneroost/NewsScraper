package ee.reneroost;

public class Util {

    public static void pauseSec(double sleepSeconds) {
        long sleepMillis = Math.round(sleepSeconds * 1000);
        try {
            Thread.sleep(sleepMillis);
            System.out.println("sleep töötas.");
        } catch (InterruptedException e) {
            throw new RuntimeException("sleep ei töötanud. " + e);
        }
    }

    public static void pauseMilliSec(int sleepMillis) {
        try {
            Thread.sleep(sleepMillis);
            System.out.println("sleep töötas.");
        } catch (InterruptedException e) {
            throw new RuntimeException("sleep ei töötanud. " + e);
        }
    }
}
