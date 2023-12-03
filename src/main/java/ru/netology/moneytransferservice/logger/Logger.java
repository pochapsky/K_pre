package ru.netology.moneytransferservice.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
public class Logger {
    private final String path;
    public Logger(String path) {
        this.path = path;
    }
    public void log(String logMessage) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(path, true))) {
            logWriter.write(logMessage);
            logWriter.newLine();
            logWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
