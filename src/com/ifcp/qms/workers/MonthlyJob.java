/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcp.qms.workers;

import com.ifcp.qms.services.Dispatcher;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.logging.Logger;

/**
 *
 * @author ispareh.m
 */
public class MonthlyJob extends Workers {

    static final Logger logger = Logger.getLogger(Dispatcher.class.toString());
    String vin;

    public MonthlyJob(String vin) {
        
        this.vin = vin;
        
    }

    public MonthlyJob() {
    }

    @Override
    public void run() {

        this.vin=id;

        System.out.printf("thread name is %s and vin is %s  \n",Thread.currentThread().getName(),id.toString());
        
    }

    public void setVin(String vin) {
        
        this.vin = vin;
        
    }
}
