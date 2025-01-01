import Appender.LogAppender;

import java.time.LocalDate;
import java.util.Date;

public class LogMessage {
    private LocalDate timeStamp;
    private String message;
    private LogLevel logLevel;

    public LogMessage(String message, LogLevel logLevel){
        this.timeStamp = LocalDate.now();
        this.message = message;
        this.logLevel = logLevel;
    }
}
