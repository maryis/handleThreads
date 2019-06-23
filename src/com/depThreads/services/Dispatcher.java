/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depThreads.services;

import com.depThreads.workers.MonthlyJob;
import com.depThreads.workers.NightlyJob;
import com.depThreads.workers.Workers;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ispareh.m
 */
public class Dispatcher {

    Workers work;
    static ExecutorService pool;
    static final Logger logger = Logger.getLogger(Dispatcher.class.toString());

    public static void dispatch(String jobName, int threadNumbers) {

        Dispatcher dispatcher = new Dispatcher();

        int[] arr = {1, 2, 3, 4, 5};

        switch (jobName) {
            case "NightlyJob":
                dispatcher.work = new NightlyJob(arr);
                break;
            case "MonthlyJob":
                dispatcher.work = new MonthlyJob(arr);
                break;
        }

        pool = Executors.newFixedThreadPool(2);
        pool.execute(new MonthlyJob(arr));
        pool.execute(new NightlyJob(arr));

        pool.shutdown(); // does one thing: prevents clients to send more work to the executor

        while(!pool.isTerminated()){}

        for (int i : arr) {
            System.out.println(i);

        }
    }

}
