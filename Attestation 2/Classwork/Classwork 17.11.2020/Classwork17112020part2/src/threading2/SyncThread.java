package threading2;

public class SyncThread extends Thread{
    private Object lock;

    public SyncThread(Object object) {
        lock = object;
    }

    public void run() {
        while(true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {}
            }
        }
    }
}
