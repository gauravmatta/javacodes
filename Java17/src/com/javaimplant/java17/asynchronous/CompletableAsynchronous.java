package com.javaimplant.java17.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableAsynchronous {
    public static void main() throws ExecutionException, InterruptedException {
        methodA();
        methodB();
        combinationFuture();
        completableException();
    }

    private static void completableException() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> compc=CompletableFuture.supplyAsync(()->10/0).exceptionally(ex->0);
        System.out.println(compc.get());
    }

    private static void combinationFuture() throws InterruptedException, ExecutionException {
        System.out.println("Starting composition of 2 Future...");
        Supplier<String> stringSupplierA=()->{
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Log(100)="+Math.log(100);
        };
        Supplier<String> stringSupplierB=()->{
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Sqrt(100)="+Math.sqrt(100);
        };
        CompletableFuture<String> futa= CompletableFuture.supplyAsync(stringSupplierA);
        CompletableFuture<String> futb= CompletableFuture.supplyAsync(stringSupplierB);
        CompletableFuture<String> combo = futa.thenCombine(futb, (resultA, resultB) -> {
            return resultA + " | " + resultB;
        });
        System.out.println("Combined Result: " + combo.get());
    }

    private static void methodB() throws InterruptedException, ExecutionException {
        Supplier<String> sup = ()->{
          try{
              Thread.sleep(5000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
         return "Log(10)="+Math.log(10);
        };
        CompletableFuture<String> compa=CompletableFuture.supplyAsync(sup);
        System.out.println("Doing other work in thread..."+ compa.get());
    }

    private static void methodA() throws InterruptedException, ExecutionException {
        CompletableFuture<String> myFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello from CompletableFuture!";
        });
        System.out.println(myFuture.get());
    }
}
