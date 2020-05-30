package Multithreading.PrintSomeText;

public class Coordinator implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++){

            Thread printer1 = new Thread(new PrinterTask("A", 99L));
            Thread printer2 = new Thread(new PrinterTask("    B", 100L));
            Thread printer3 = new Thread(new PrinterTask("------ C ------", 0L));

            printer1.start();
            printer2.start();

            try {
                printer1.join();
                printer2.join();
                printer3.start();
                printer3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
