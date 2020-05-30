package Multithreading.PrintSomeText;

public class PrinterTask implements Runnable {
    private String text;
    private Long sleepTime;

    public PrinterTask(String text, Long sleepTime) {
        this.text = text;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(text);
        }
    }
}
