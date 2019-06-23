/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depThreads.workers;


import com.depThreads.services.Dispatcher;

import java.util.logging.Logger;

public class NightlyJob extends Workers {

    static final Logger logger = Logger.getLogger(Dispatcher.class.toString());
    int[] arr;


    public NightlyJob(int[] arr) {

        this.arr = arr;

    }


    @Override
    public void run() {

        //UtilSynchStaticMethod.multiple(arr,10);  //it is useful for our condition

//        UtilSynchInstanceMethod utilSynchArr=new UtilSynchInstanceMethod(); //it does not work for our example (per instance)
//        utilSynchArr.multiple(arr,10);

        UtilSynchBlock utilSynchBlock = new UtilSynchBlock(); //it is useful for our condition
        utilSynchBlock.multiple(arr, 10);


        for (int i : arr) {
            System.out.println("thread Night(but maybe the other thread executed):" + i);

        }
    }
}
