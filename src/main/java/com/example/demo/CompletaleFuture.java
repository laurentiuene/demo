package com.example.demo;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class CompletaleFuture {

    public static int combine(int par1, int par2, int par3, int par4) {
        return par1 + par2 + par3 + par4;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> x1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> x2 = CompletableFuture.supplyAsync(() -> 100);
        BiFunction<Integer, Integer, Integer> combine = Integer::sum;
        CompletableFuture<Integer> x3 =CompletableFuture
                .supplyAsync( () -> {
                    System.out.println("SupplyAsync -> " + 2);
                    return 2;})
                .thenApply(x -> {
                    System.out.println("thenApply -> " + (x + 2));
                    return x + 2;})
//                .thenAccept(x -> {
//                    System.out.println("thenAccept -> " + (x + 2));
//                })
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("thenCompose -> " + (x + 2));
                    return x + 2;}))
                .thenCombine(x1, combine)
                .thenCombine(x2, combine);

        System.out.println(x3.get());

        //fac un combine vs compose
        //fac un thread pool si vad cum se comorta
        //exceptions
//------------------------------------------------------------------------------------
        CompletableFuture<Integer> aCompletionStage = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> bCompletionStage = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> cCompletionStage = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<Integer> dCompletionStage = CompletableFuture.supplyAsync(() -> 1000);

        CompletableFuture<Integer> combinedDataCompletionStage = CompletableFuture.allOf(
                        aCompletionStage, bCompletionStage, cCompletionStage, dCompletionStage)
                .thenApply(ignoredVoid -> combine(
                        aCompletionStage.join(), bCompletionStage.join(),
                        cCompletionStage.join(), dCompletionStage.join()));

        System.out.println("combine neboonie --> " + combinedDataCompletionStage.get());
//------------------------------------------------------------------------------------
        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        executorService.submit(threadLocal.)
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        CompletableFuture<Integer> x4 = CompletableFuture
                .supplyAsync(() -> {
                    threadLocal.set(2);
                    System.out.println("SupplyAsync -> " + Thread.currentThread().getName());
                    return 2;}, executorService)
                .thenApplyAsync(x -> {
                    System.out.println("threadLocal -> " + threadLocal.get());
                    System.out.println("ThenApply1 -> " + Thread.currentThread().getName());
                    return x + 2;}, executorService);


    }
}
