package com.example.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ExecutorServiceExample {
    //ExecutorService is a complete solution for asynchronous processing.
    // It manages an in-memory queue and schedules submitted tasks based on thread availability.

    public static class RunnableClass implements Runnable {

        @Override
        public void run() {
            System.out.println("din run zic --> "+Thread.currentThread().getName());
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new RunnableClass());
        executor.submit(new RunnableClass());
        executor.submit(new RunnableClass());
        executor.submit(new RunnableClass());

        executor.shutdown();
    }
}
