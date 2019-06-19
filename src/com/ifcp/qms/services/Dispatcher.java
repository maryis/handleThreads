/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcp.qms.services;

import com.ifcp.qms.workers.NightlyJob;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ifcp.qms.workers.MonthlyJob;
import com.ifcp.qms.workers.Workers;

/**
 * @author ispareh.m
 */
public class Dispatcher {

    Workers work;
    static ExecutorService pool;
    static final Logger logger = Logger.getLogger(Dispatcher.class.toString());

    public static void dispatch(String jobName, int threadNumbers) {

        Dispatcher dispatcher = new Dispatcher();

        switch (jobName) {
            case "NightlyJob":
                dispatcher.work = new NightlyJob();
                break;
            case "MonthlyJob":
                dispatcher.work = new MonthlyJob();
                break;
        }

        List<Integer> list = Stream.iterate(1, n -> n + 3)
                .limit(100)
                .collect(Collectors.toList());

        pool = Executors.newFixedThreadPool(threadNumbers);  //for independent threads

        list.forEach(item -> dispatcher.runThreads(item));
//        while (it.hasNext()) {
//            work.setId(it.next().getVin());
//            pool.execute(work);
//        }

        pool.shutdown();
    }

    private void runThreads(int id) {
        work.setId(Integer.toString(id));
        pool.execute(work);

    }

}
