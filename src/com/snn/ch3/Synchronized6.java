package com.snn.ch3;

/**
 * @className Synchronized5
 * @Author lulu
 * @Date 2019-08-28 15:04
 * 6、同时访问静态Synchronized方法和非静态Synchronized方法：同时开始，同时结束（因为指定的锁对象不是同一个锁）
 **/
public class Synchronized6 implements Runnable {

    static Synchronized6 instance = new Synchronized6();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized static void method1() {
        // 锁对象是class对象
        System.out.println("我是静态加锁的方法1，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2() {
        // 锁对象是this
        System.out.println("我是非静态加锁的方法2，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finishedsss");
    }
}
