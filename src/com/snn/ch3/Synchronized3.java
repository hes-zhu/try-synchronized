package com.snn.ch3;

/**
 * @className Synchronized5
 * @Author lulu
 * @Date 2019-08-28 15:04
 * 3、两个线程访问的是synchronized的静态方法：串行执行，因为用了类锁的static形式，用的是同一个类锁
 **/
public class Synchronized3 implements Runnable {

    static Synchronized3 instance1 = new Synchronized3();
    static Synchronized3 instance2 = new Synchronized3();

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我的类锁的第一种形式：static形式，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
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
}
