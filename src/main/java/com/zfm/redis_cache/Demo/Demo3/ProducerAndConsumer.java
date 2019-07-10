package com.zfm.redis_cache.Demo.Demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zfm
 * @Description TODO
 * @date 2019/7/10
 */
public class ProducerAndConsumer {

    boolean flag = false;
    Lock lock = new ReentrantLock();
    Condition producerCon = lock.newCondition();
    Condition consumerCon = lock.newCondition();

    public void producer() {
        try {
            lock.lock();
            if (flag) {
                System.out.println("还有食物，暂时不需要生产");
                System.out.println(Thread.currentThread().getName());
                try {
                    producerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            System.out.println("生产者生产了食物");
            System.out.println(Thread.currentThread().getName());
            consumerCon.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("1");
            lock.unlock();

        }

    }

    public void consumer() {
        try {
            lock.lock();
            if (!flag) {
                System.out.println("没有食物了,通知生产者生产");
                System.out.println(Thread.currentThread().getName());
                try {
                    consumerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者进食中");
            System.out.println(Thread.currentThread().getName());
            flag = false;
            producerCon.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("2");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ProducerAndConsumer pac = new ProducerAndConsumer();
        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                pac.producer();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 3; i++)
                pac.consumer();
        }).start();
    }
}


