package com.example.demo.concurrent;

import java.util.concurrent.*;

public class FutureExample {
    //Future is used to represent the result of an asynchronous operation.
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            // ...
            Thread.sleep(10000);
            return "Hello world";
        });

        try {
            System.out.println(future.get(11, TimeUnit.SECONDS));

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
