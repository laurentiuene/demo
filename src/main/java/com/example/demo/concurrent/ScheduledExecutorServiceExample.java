package com.example.demo.concurrent;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {
//    ScheduledExecutorService is a similar interface to ExecutorService, but it can perform tasks periodically.

    public static void main(String[] args) {
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        System.out.println("din schedule zic --> "+Thread.currentThread().getName());

        Future<String> future = executorService.schedule(() -> {
            System.out.println("din schedule zic --> "+Thread.currentThread().getName());
            return "Hello world";
        }, 1, TimeUnit.SECONDS); //one time thing with interface Callable

//        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
//            // ...
//        }, 1, TimeUnit.SECONDS); //one time thing with interface Runnable

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("din scheduleAtFixedRate zic --> "+Thread.currentThread().getName());
        }, 1, 10, TimeUnit.SECONDS);

//        executorService.scheduleWithFixedDelay(() -> {
//            // ...
//        }, 1, 10, TimeUnit.SECONDS);

//        executorService.shutdown();
    }
}
