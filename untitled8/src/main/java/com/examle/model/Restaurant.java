package com.examle.model;

import com.examle.model.CashRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Restaurant {
    private static final Logger logger = LogManager.getLogger(Restaurant.class);
    private CashRegister[] registers;

    public Restaurant(int numRegisters) {
        registers = new CashRegister[numRegisters];
        for (int i = 0; i < numRegisters; i++) {
            registers[i] = new CashRegister();
        }
    }


    public void serveAllConcurrently() {

        for (int i = 0; i < registers.length; i++) {
            Thread thread = new Thread(registers[i]);
            thread.start();
        }
    }


    public void addVisitorToRegister(int registerIndex, String visitorName) {
        if (registerIndex < registers.length) {
            registers[registerIndex].addVisitor(visitorName);
        } else {
            logger.warn("Invalid register index.");
        }
    }


    public void printStatus() {
        for (int i = 0; i < registers.length; i++) {
            registers[i].printQueue();
        }
    }
}
