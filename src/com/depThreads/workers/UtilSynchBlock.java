package com.depThreads.workers;

public class UtilSynchBlock {

    public void multiple(int[] arr, int mult) {
        synchronized (arr) {  //just one thread can work with arr in a time
            //or synchronized (UtilSynchBlock.class) or synchronized(this) or ...

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

