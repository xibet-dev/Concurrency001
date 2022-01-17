class Daemon implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a daemon thread");
    }
}

public class DaemonThread008 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Daemon());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());

    }

}
