package com.snn.ch5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @className SychronizedToLock1
 * @Author lulu
 * @Date 2019-08-28 19:21
 **/
public class SynchronizedToLock1 {

    Lock lock = new ReentrantLock();

    public synchronized  void  method1() {
        System.out.println("我是Synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock1 synchronizedToLock1 = new SynchronizedToLock1();
        synchronizedToLock1.method1();
        synchronizedToLock1.method2();
    }

}
