package MyExecuterService;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class SimpleExecutorService {
    private final ThreadGroup group = new ThreadGroup("ExecutorsGroup");
    private final Collection<Thread> workersPool = new ArrayList<>();
    private final BlockingQueue<Callable> taskQueue;

    public SimpleExecutorService(int threadCount, BlockingQueue<Callable> taskQueue) {
        this.taskQueue = taskQueue;

        for (int i = 0; i < threadCount; i++){
            Thread worker = new Thread(group, new Worker());
            worker.start();
            workersPool.add(worker);
        }
    }

    public <T> void submit(Callable<T> task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdown(){
        group.interrupt();
    }

    private class Worker implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    Callable nextTask = taskQueue.take();
                    nextTask.call();
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
