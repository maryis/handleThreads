/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.indepThreads.services;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ispareh.m
 */

public class Controller {

    static final Logger logger = Logger.getLogger(Controller.class.toString());

    public static void main(String[] args) {

        try {

            String jobName = "";

            logger.log(Level.INFO, "Available processor: {0}", Runtime.getRuntime().availableProcessors());

            if (args.length < 2) {
                logger.log(Level.INFO, "Please provide type of the job and the number of threads correctly->  1:nightly, 2:monthly ");
                System.exit(0);
            } else if (args[0].equals("1")) {
                jobName = "NightlyJob";
            } else if (args[0].equals("2")) {
                jobName = "MonthlyJob";
            } else {
                logger.log(Level.INFO, "Wrong Type of job : {0}",args[0]);
                System.exit(0);
            }

            int threadNum = Integer.valueOf(args[1]);

            logger.log(Level.INFO, "Type of the job: {0}", jobName);

            //if there is no wait for IO or .., the best number of threads:availableProcessors
            //else availableProcessors + n
            //to debug multi-thread, 1- set breakpoints 2- debug 3- f9 to go to breakpoint in thread

            Dispatcher.dispatch(jobName, threadNum);

            System.exit(0);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
