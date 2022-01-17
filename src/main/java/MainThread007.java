public class MainThread007 {

    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println("Current thread is: " + name);
    }
}
