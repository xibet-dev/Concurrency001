class RunnerOne implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("#Runner1: " + i);
        }
    }
}

class RunnerTwo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("@Runner2: " + i);
        }
    }
}

public class MultithreadRunnableApp003 {

    public static void main(String[] args) {

        //It is multithreaded execution (time-slicing algorithm is used)
        //It is not parallel execution
        Thread t1 = new Thread(new RunnerOne());
        Thread t2 = new Thread(new RunnerTwo());
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println("*Runner3: " + i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Finished with thread...");
    }
}
