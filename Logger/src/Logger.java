import Appender.LogAppender;

public class Logger {
    private LogConfig logConfig;
    private LogMessage logMessage;

    public void setConfig(LogLevel logLevel, LogAppender logAppender){
        logConfig = new LogConfig(logLevel, logAppender);
    }

    public void logMessage(String message, LogLevel level){
        LogLevel logLevel = logConfig.getLogLevel();
        //Conditions

        LogAppender logAppender = logConfig.getLogAppender();

        


    }
}
