package Multithreading.PrintSomeText;

public class MultithreadPrint {
    public static void main(String[] args) {
        System.out.println("START");
        Thread coordinator = new Thread(new Coordinator());
        coordinator.start();
        try {
            coordinator.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FINISH");
    }
}
