import Appender.ConsoleAppender;
import Appender.LogAppender;
import LogMessager.LogLevel;
import LogMessager.LogMessage;

public class Logger {
    private LogConfig logConfig;
    private LogMessage logMessage;

    private static Logger log = null;

    private Logger(){
        this.logConfig = new LogConfig(LogLevel.DEBUG, new ConsoleAppender());
    }

    public static Logger getInstance(){
        if(log == null){
            System.out.println("New logger created");
            return new Logger();
        }
        System.out.println("New logger created 1");
        return log;
    }
    public void setConfig(LogLevel logLevel, LogAppender logAppender){
        logConfig = new LogConfig(logLevel, logAppender);
    }

    public void logMessage(String message, LogLevel level){
        LogLevel logLevel = logConfig.getLogLevel();
        if(level.ordinal() >= logLevel.ordinal()){
            LogAppender logAppender = logConfig.getLogAppender();
            LogMessage logMessage = new LogMessage(message, level);
            logAppender.logMessage(logMessage);
        }
    }

    public void debug(String message){
        logMessage(message,LogLevel.DEBUG);
    }

    public void Info(String message){
        logMessage(message, LogLevel.INFO);
    }

}
