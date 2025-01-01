package Appender;

public class FileAppender implements LogAppender{
    @Override
    public void logMessage(String message) {
        System.out.println("message logged");
    }
}
