package Appender;

import LogMessager.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    @Override
    public void logMessage(LogMessage message) {
        System.out.println("printed in file");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            System.out.println("aad");
            writer.write(message.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
