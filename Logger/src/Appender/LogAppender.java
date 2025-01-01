package Appender;

import LogMessager.LogMessage;

import java.io.IOException;

public interface LogAppender {
    public void logMessage(LogMessage message);
}
