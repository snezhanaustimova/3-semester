package com.company;

public class CountThread implements Runnable {
    CommonResurce res;
    CountThread(CommonResurce res) {
        this.res = res;
    }

    /*@Override
    public void run(){
        synchronized (res) {
            res.x = 1;
            for (int i = 1; i<5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        }
    }*/

    @Override
    public void run() {
        res.increment();
    }
}
