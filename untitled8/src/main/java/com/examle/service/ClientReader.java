package com.examle.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientReader {

    // Read client names from a file
    public List<String> readClientsFromFile(String fileName) {
        List<String> clients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clients.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
