package com.examle.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class CashRegister implements Runnable {
    private static final Logger logger = LogManager.getLogger(CashRegister.class);
    private Queue<String> queue = new LinkedList<>();


    public void addVisitor(String visitorName) {
        queue.add(visitorName);
        logger.info("Visitor " + visitorName + " added to the queue.");
    }


    public void serveVisitor() {
        if (!queue.isEmpty()) {
            String visitorName = queue.poll();
            logger.info("Visitor " + visitorName + " served.");
        } else {
            logger.warn("Queue is empty.");
        }
    }


    public void printQueue() {
        logger.info("Current queue: " + queue);
    }

    @Override
    public void run() {

        while (!queue.isEmpty()) {
            serveVisitor();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

