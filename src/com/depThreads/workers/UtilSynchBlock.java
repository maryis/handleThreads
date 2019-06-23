package com.depThreads.workers;

public class UtilSynchBlock {

    public void multiple(int[] arr, int mult) {
        synchronized (arr) {  //synchronized (UtilSynchBlock.class)

            for (int i = 0; i < arr.length; i++)
                arr[i] = arr[i] * mult;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i : arr) {
                System.out.println("util(inside synchronized):" + i);

            }

        }
    }
}

