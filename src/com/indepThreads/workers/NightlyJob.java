/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indepThreads.workers;


import com.indepThreads.services.Dispatcher;

import java.util.logging.Logger;

public class NightlyJob  extends Workers {

    static final Logger logger = Logger.getLogger(Dispatcher.class.toString());
    String vin;

    public NightlyJob(String vin) {
        this.vin = vin;
    }

    public NightlyJob() {
    }

    @Override
    public void run() {

        this.vin=id;
        System.out.printf("thread name is %s and vin is %s \n ",Thread.currentThread().getName(),id.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    
}
