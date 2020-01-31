package test0131.demo0001;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPool {

    private static class Woker extends Thread{

    }

    private BlockingQueue<Runnable> jobQueue;
    private int nCurruentThreads;
    private int nThreads;
    private Woker[] wokers;

    public ThreadPool(int nThreads, int nCachedJobs){
        this.jobQueue = new ArrayBlockingQueue<>(nCachedJobs);
        this.nCurruentThreads = 0;
        this.nThreads = nThreads;
        this.wokers = new Woker[nThreads];
    }

    public void execute(Runnable command) throws InterruptedException{
        if (nCurruentThreads < nThreads){
            Woker woker = new Woker();
            wokers[nCurruentThreads++] = woker;
            woker.start();
        }else{
            jobQueue.put(command);
        }

    }

}
