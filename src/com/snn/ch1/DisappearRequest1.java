package com.snn.ch1;

/**
 * @className DisappearRequest1
 * @Author lulu
 * @Date 2019-08-28 09:41
 **/
public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }

    @Override
    public void run() {
        synchronized (DisappearRequest1.class) {
              for (int j = 0; j < 100000; j++) {
                  i++;
              }
        }
    }

    // 解决的几种方法
    /**
    * 1、对象锁--方法锁形式：public synchronized void run()----直接添加synchronized关键字
    * 2、对象锁--代码块：synchronized (this) {
     *             for (int j = 0; j < 100000; j++) {
     *                 i++;
     *             }
     *         }
    * 3、类锁--(*.class)形式：synchronized (DisappearRequest1.class) {
     *               for (int j = 0; j < 100000; j++) {
     *                   i++;
     *               }
     *         }
    * 4、类锁-static形式：不能以static形式重写run方法
    * */
}
