package com.example.demo.concurrent;

import java.util.concurrent.Executor;

public class ExecutorExample {
    // Executor is an interface that represents an object that executes provided tasks.
    public static class Invoker implements Executor {
        @Override
        public void execute(Runnable r) {
            System.out.println("din execute zic --> " + Thread.currentThread().getName());
//            r.run();
            Thread t = new Thread(r);
            t.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("din main zic --> "+Thread.currentThread().getName());
        Executor executor = new Invoker();

        executor.execute( () -> System.out.println( "1.din invocarea execute-ului zic --> " + Thread.currentThread().getName()));
        executor.execute( () -> System.out.println( "2.din invocarea execute-ului zic --> " + Thread.currentThread().getName()));

    }
}
