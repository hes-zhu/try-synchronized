package com.snn.ch4;

/**
 * @className SynchronizedSuperClass3
 * @Author lulu
 * @Date 2019-08-28 18:36
 * 可重入粒度测试，调用父类的方法
 **/
public class SynchronizedSuperClass3 {

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }

}

class TestClass extends SynchronizedSuperClass3 {
    @Override
    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass s = new TestClass();
        s.doSomething();
    }
}
