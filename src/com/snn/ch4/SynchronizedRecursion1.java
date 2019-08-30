package com.snn.ch4;

/**
 * @className SynchronizedRecursion
 * @Author lulu
 * @Date 2019-08-28 18:24
 * 可重入粒度测试，递归调用本地方法
 **/
public class SynchronizedRecursion1 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion1 synchronizedRecursion1 = new SynchronizedRecursion1();
        synchronizedRecursion1.method1();
    }

    private synchronized void method1() {
        System.out.println("这是method1，a = "+a);
        if(a == 0) {
            a++;
            method1();
        }
    }
}
