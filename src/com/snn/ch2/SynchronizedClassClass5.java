package com.snn.ch2;

/**
 * @className SynchrorizedClassClass5
 * @Author lulu
 * @Date 2019-08-28 11:32
 * 类锁的第二种形式   (*.class)形式
 **/
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    private void method() throws InterruptedException {
        synchronized (SynchronizedClassClass5.class) {
//        synchronized (this) {
                System.out.println("我是类锁的第二种形式：synchronized（*.class）。我叫" + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finishedsss");
    }

    @Override
    public void run() {
        try {
            this.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
