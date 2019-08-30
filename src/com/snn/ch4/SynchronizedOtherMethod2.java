package com.snn.ch4;

/**
 * @className SynchronizedOtherMethod
 * @Author lulu
 * @Date 2019-08-28 18:31
 * 可重入粒度测试，调用类另外的方法
 **/
public class SynchronizedOtherMethod2 {

    public synchronized void method1() {
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("我是方法2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod2 synchronizedOtherMethod2 = new SynchronizedOtherMethod2();
        synchronizedOtherMethod2.method1();
    }
}
