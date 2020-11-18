package Configuration;

import java.io.FileInputStream;
import java.util.Properties;

import LogHandler.Log;
/*
 * This is a config file handler and contains all the functionality for
 * creating and changing any key value pair in config.properties file...
 */
public class Config {
	public static Properties prop = null;
	private static String configFilePath = "src\\main\\resources\\Configuarations\\config.properties";
	public static void initialiseConfig(){
		try {
			if(prop == null) {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(configFilePath);
				prop.load(fis);
			}
		}
		catch(Exception fileLoadError){
			Log.error("File Not Found / Unable to access the file.");
			fileLoadError.toString();
		}
	}
	public static String getProperty(String key) {
		initialiseConfig();
		if(prop.getProperty(key) != null)
			return prop.getProperty(key);
		else
			Log.error("NULL value found for key " + key);
		return null;
	}
	public static void setProperty(String key, String value) {
		initialiseConfig();
		prop.setProperty(key, value);
		Log.info("Setting property key and value -> " + key + " - " + value);
	}
}