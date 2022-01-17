class Runner1{

    public void execute(){
        for (int i = 0; i < 10; i++){
            System.out.println("Runner1: " + i);
        }
    }

}

class Runner2{

    public void execute(){
        for (int i = 0; i < 10; i++){
            System.out.println("Runner2: " + i);
        }
    }

}

public class SequentialProcessingApp002 {

    public static void main(String[] args) {
        //sequential processing
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        runner1.execute();
        runner2.execute();
    }
}
