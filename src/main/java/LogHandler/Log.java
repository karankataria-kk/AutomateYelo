package LogHandler;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/*
 * This is a log handler file which contains all the setup for creating and logging the logs in the 
 * log file with all the functions i.e. -> Info, Warning, Debug, Fatal, Error. This logs the data in
 * a format containing all the relevant information like time and the kind of log.
 */
public class Log {
	static Logger logger =  null;
	static String logFilePath = "src\\main\\java\\LogHandler\\log4j.xml";
	public static Logger getLogger() {
		if (logger==null)
			initializeLog(Log.class,logFilePath);
		return logger;
	}
	private static void initializeLog(Class logClass, String logFilePath) {
		logger = Logger.getLogger(logClass);
		DOMConfigurator.configure(logFilePath);
	}    
	public static void info(String message){
		getLogger();
		logger.info(message);			
	}
	public static void warn(String message) {
		getLogger();
		logger.warn(message);
	}
	public static void error(String message) {
		getLogger();
		logger.error(message);
	}
	public static void fatal(String message) {
		getLogger();
		logger.fatal(message);
	}
	public void debug(String message) {
		getLogger();
		logger.debug(message);
	}
}