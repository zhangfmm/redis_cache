package com.zfm.redis_cache.config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zfm
 * @Description TODO
 * @date 2019/7/3
 */
public class LockCoditionText {
    final Business business = new Business();

    public static void main(String[] args) {
//        new LockCoditionText().init();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEachOrdered((a)->{
                    System.out.println(a);
                });
    }

    private void init() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 50; i++) {
                    business.sub2(i);
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i <= 50; i++) {
                    business.sub3(i);
                }
            }
        }).start();

        for (int i = 0; i <= 50; i++) {
            business.main(i);
        }

    }

    class Business {
        private int flag = 1;
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2= lock.newCondition();
        Condition condition3= lock.newCondition();
        public void sub2(int i) {
            lock.lock();
            try {
                while (flag!=2) {
                    condition2.await();
                }

                for (int j = 1; j <= 10; j++) {

                    System.out.println("sub2 thread sequence of" + j
                            + ",loop of " + i);
                }
                flag = 3;
                condition3.signal();
            } catch (Exception e) {

                e.printStackTrace();

            } finally {
                lock.unlock();
            }
        }

        public void sub3(int i) {
            lock.lock();
            try {
                while (flag!=3) {
                    condition3.await();
                }

                for (int j = 1; j <= 10; j++) {

                    System.out.println("sub3 thread sequence of" + j
                            + ",loop of " + i);
                }
                flag =1;
                condition1.signal();
            } catch (Exception e) {

                e.printStackTrace();

            } finally {
                lock.unlock();
            }
        }

        public synchronized void main(int i) {
            lock.lock();
            try {
                while (flag!=1) {
                    condition1.await();
                }

                for (int j = 1; j <= 20; j++) {

                    System.out.println("main thread sequence of" + j
                            + ",loop of " + i);
                }
                flag = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}