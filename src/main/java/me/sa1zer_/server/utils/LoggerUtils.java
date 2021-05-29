package me.sa1zer_.server.utils;


import me.sa1zer_.server.MainServer;
import org.apache.log4j.Logger;

public class LoggerUtils {

    private static Logger logger;

    static {
        logger = Logger.getLogger(MainServer.class);
    }

    public static void log(LogType type, String msg) {
        switch (type) {
            case LOG_ERROR:
                logger.error(msg);
                break;
            case LOG_WARNING:
                logger.warn(msg);
                break;
            default:
                logger.info(msg);
        }
    }

    public enum LogType {

        LOG_ERROR, LOG_INFO, LOG_WARNING
    }
}
