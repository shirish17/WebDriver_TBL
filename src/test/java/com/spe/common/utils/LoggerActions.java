package com.spe.common.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoggerActions 
{
	WebDriver driver;
	public static String fsep=System.getProperty("file.separator");
	public LoggerActions()
	{
		System.setProperty("logfile.name", (System.getProperty("user.dir")+fsep+"target" + fsep + "Logs"+fsep+"log4j-application.log"));
	}
public static Logger Log = Logger.getLogger(LoggerActions.class.getName());
	
	public static void info(String message)
	{
		Log.info(message);
	}
	public static void warn(String message) 
	{
		Log.warn(message);
	}
	public static void error(String message)
	{
		Log.error(message);
	}
	public static void fatal(String message)
	{
		Log.fatal(message);
	}
	public static void debug(String message)
	{
		Log.debug(message);
	}
}
