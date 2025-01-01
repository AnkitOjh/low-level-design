import Appender.LogAppender;
import LogMessager.LogLevel;

public class LogConfig {
    private LogLevel logLevel;
    private LogAppender logAppender;

    public LogConfig(LogLevel logLevel, LogAppender logAppender){
        this.logLevel  = logLevel;
        this.logAppender = logAppender;
    }

    public LogAppender getLogAppender(){
        return this.logAppender;
    }

    public LogLevel getLogLevel(){
        return this.logLevel;
    }
}
