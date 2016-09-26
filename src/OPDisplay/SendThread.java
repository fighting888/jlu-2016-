package OPDisplay;

/**
 * Created by PurpleWall on 2016/9/26.
 */
public class SendThread extends Thread {

    private static int time = 0;

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        SendProcess s = new SendProcess(1);
        (new SendThread()).start();
    }
}
