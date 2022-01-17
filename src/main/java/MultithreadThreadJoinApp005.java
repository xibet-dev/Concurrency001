class RunnerA extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("#Runner1: " + i);
        }
    }
}

class RunnerB extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("@Runner2: " + i);
        }
    }
}

public class MultithreadThreadJoinApp005 {

    public static void main(String[] args) {

        //It is multithreaded execution (time-slicing algorithm is used)
        //It is not parallel execution
        Thread t1 = new Thread(new RunnerA());
        Thread t2 = new Thread(new RunnerB());
        Thread t3 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("*Runner3: " + i);
                }
            }
        };

        t1.start();
        t2.start();
        //t3.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished with threads...");
    }
}
