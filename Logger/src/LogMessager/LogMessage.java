package LogMessager;

import Appender.LogAppender;

import java.time.LocalDate;
import java.util.Date;

public class LogMessage {
    private final LocalDate timeStamp;
    private final String message;
    private final LogLevel logLevel;

    public LogMessage(String message, LogLevel logLevel){
        this.timeStamp = LocalDate.now();
        this.message = message;
        this.logLevel = logLevel;
    }

    public String getMessage(){
        return this.message;
    }

    public LogLevel getLevel(){
        return this.logLevel;
    }
    public LocalDate getTimeStamp(){
        return this.timeStamp;
    }
}
