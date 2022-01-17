class DaemonThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon thread is running");
        }
    }
}

class WorkerThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker thread finished execution...");
    }
}


public class DaemonAndWorkerThreads009 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new DaemonThread());
        t1.setDaemon(true);

        Thread t2 = new Thread(new WorkerThread());

        t1.start();
        t2.start();
    }

}
