package com.examle.main;

import com.examle.model.Restaurant;
import com.examle.service.ClientReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(3);

        ClientReader clientReader = new ClientReader();

        List<String> clients = clientReader.readClientsFromFile("src/main/resources/clients.txt");

        for (int i = 0; i < clients.size(); i++) {
            int registerIndex = i % 3;
            restaurant.addVisitorToRegister(registerIndex, clients.get(i));
        }

        restaurant.printStatus();

        restaurant.serveAllConcurrently();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        restaurant.printStatus();
    }
}
