package Appender;
public class DatabaseAppender implements LogAppender{
    private String logMessage;
    public DatabaseAppender(String logMessage){
        this.logMessage = logMessage;
    }

    @Override
    public void logMessage(String message) {
        System.out.println("Database log");
    }
}
