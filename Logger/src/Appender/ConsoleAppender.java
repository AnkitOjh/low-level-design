package Appender;

public class ConsoleAppender implements  LogAppender{
    @Override
    public void logMessage(String message) {
        System.out.println("Logged in console");
    }
}
