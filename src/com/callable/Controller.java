package com.callable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Controller {

    public static void main(String[] args) {

        Callable<Integer> exampleCall1 = () -> { //it is equivalent to writing callable class and override call()
            Random generator = new Random();
            Integer randomNumber = generator.nextInt(5);
            Thread.sleep(randomNumber * 1000);
            return randomNumber;
        };
        Callable<Integer> exampleCall2 = () -> { //it is equivalent to writing callable class and override call()
            Random generator = new Random();
            Integer randomNumber = generator.nextInt(5);
            Thread.sleep(randomNumber * 2000);
            return randomNumber;
        };
        Callable<Integer> exampleCall3 = () -> { //it is equivalent to writing callable class and override call()
            Random generator = new Random();
            Integer randomNumber = generator.nextInt(5);
            Thread.sleep(randomNumber * 3000);
            return randomNumber;
        };

        List<Callable<Integer>> taskList= Arrays.asList(exampleCall1,exampleCall2,exampleCall3);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //Future<Integer> result = executorService.submit(exampleCall); //submit one task
        List<Future<Integer>> results=null;
        try {
            results=executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        results.forEach((res)->{
            try {
                if (res.isDone())

                    System.out.println("result : " + res.get().toString());

                else

                    Thread.sleep(1000);

            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        });

        executorService.shutdown();
    }
}
