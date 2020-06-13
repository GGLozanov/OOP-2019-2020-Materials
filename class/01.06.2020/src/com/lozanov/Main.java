package com.lozanov;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        // Thread class with static methods for threads
        System.out.println(Thread.activeCount()); // returns current thread count
        Thread.sleep(2000); // current thread wait milliseconds

        System.out.println("Goodbye");

        Thread thread = new Thread(); // empty thread
        thread.start(); // starts thread

        thread.join(); // throws exception

        System.out.println(Thread.currentThread());
        /* Thread threadWithMethod = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
                System.out.println("Hello from thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Goodbye");
            }
        }); // non-empty thread

        threadWithMethod.start();
        threadWithMethod.join(); */

//        Thread thread1WithRunnable = new Thread(new Player(new Ball(1, 0), 1));
//        Thread thread2WithRunnable = new Thread(new Player(new Ball(1, 0), -1));
//
//        thread1WithRunnable.start();
//        thread2WithRunnable.start();
//
//        try {
//            thread1WithRunnable.join();
//            thread2WithRunnable.join();
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }

        Executor executor = Executors.newFixedThreadPool(2); // executor is an interface for thread running
        // saves boilerplate for writing threads
        // create an executor with a fixed thread amount (thread pool)
        // wrapper class to ease writing so much code with start() and join()

        executor.execute(new Player(new Ball(1, 0), 1));
        executor.execute(new Player(new Ball(1, 0), -1));
    }
}
