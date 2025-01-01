package Appender;

import LogMessager.LogMessage;

public class ConsoleAppender implements  LogAppender{
    @Override
    public void logMessage(LogMessage message) {
        System.out.println(message.getMessage());
    }
}
