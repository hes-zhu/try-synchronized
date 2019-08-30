package com.snn.ch3;

/**
 * @className Synchronized5
 * @Author lulu
 * @Date 2019-08-28 15:04
 * 2、两个线程访问的是两个对象的同步方法：并行执行，因为他们的锁是对应自己当前对象，有两个锁
 **/
public class Synchronized2 implements Runnable {

    static Synchronized2 instance1 = new Synchronized2();
    static Synchronized2 instance2 = new Synchronized2();

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式，我是" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束！");
        }
    }



    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
