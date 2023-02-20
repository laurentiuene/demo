package com.example.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class CyclicBarrierExample {
    //Unlike CountDownLatch, it allows multiple threads to wait for each other using await() method(known as barrier condition) before invoking the final task.

    public static class Task implements Runnable {

        private final CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("din run la inceput zic --> "+Thread.currentThread().getName() + " is waiting");
                barrier.await();
                System.out.println("din run la final zic --> "+Thread.currentThread().getName() + " is released");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            // ...
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "T3");
        Thread t4 = new Thread(new Task(cyclicBarrier), "T4");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            sleep(10000);
            t2.start();
            sleep(10000);
            t3.start();
            sleep(10000);
            t4.start();
        }
    }
}
