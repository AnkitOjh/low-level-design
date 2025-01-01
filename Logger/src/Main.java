import Appender.ConsoleAppender;
import Appender.FileAppender;
import LogMessager.LogLevel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Logger logger = Logger.getInstance();
        logger.debug("Config is set to debug");
        logger.setConfig(LogLevel.DEBUG,new FileAppender());
        logger.debug("After setting info to config");
    }
}