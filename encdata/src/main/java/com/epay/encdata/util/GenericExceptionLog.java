/**************************************************************************************************
 * @(#)GenericExceptionLog.java
 * Copyright 2013 State Bank of India. All Rights Reserved.
 * This software is the proprietary information of State Bank of India.
 * Use is subject to license terms.
 ***************************************************************************************************/
package com.epay.encdata.util;
import java.text.SimpleDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericExceptionLog {
	private static final Logger logDebug = LogManager.getLogger("logDebug");
	private static final Logger logInfo = LogManager.getLogger("logInfo");
	private static final Logger logError = LogManager.getLogger("logError");

	/****************************************************************************************************
	 * Following Method Simply Writes the text sent to it by the programme
	 * invokingthis method to the file
	 * LOG prints logging as DEBUG
	 ***************************************************************************************************/

	public static void log(String text) {
		System.out.println(" Logdebug:="+logDebug);
		if (logDebug.isDebugEnabled()) {
			logDebug.debug(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [DEBUG] " + text);;
		}

	}

	public static void log(String text, String filename) {
		if (logDebug.isDebugEnabled()) {
			logDebug.debug(text + " - " + filename);
		}

	}

	/****************************************************************************************************
	 * Following Method Simply Writes the text sent to it by the programme
	 * invokingthis method to the file
	 ***************************************************************************************************/
	public static void info(String text) {
		if (logInfo.isInfoEnabled()) {
			logInfo.info(text);
		}

	}

	public static void info(String text, String filename) {
		if (logInfo.isInfoEnabled()) {
			logInfo.info(text);
		}

	}

	/****************************************************************************************************
	 * Following Method Simply Writes the text ,along with Date (Time of
	 * occurence of exception ) sent to it by the JSP invoking this method to
	 * the file
	 ***************************************************************************************************/

	public static void exceptionJsp(java.lang.Exception e, String url) {

		if (logError.isErrorEnabled()) {
			logError.error(" [ERROR] The Exception is \t" + e + " Occured on page \t" + url);
		}

	}

	public static void exceptionJsp(java.lang.Exception e, String url, String filename) {
		if (logError.isErrorEnabled()) {
			logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The Exception is \t" + e + " Occured on page \t" + url + "- " + filename);
		}

	}

	/****************************************************************************************************
	 * Following Method Simply Writes the text ,along with Date (Time of
	 * occurence of exception ) sent to it by the Java programe invoking this
	 * method to the file
	 ***************************************************************************************************/

	public static void exceptionJava(java.lang.Exception e, String filename) {
		String text = "The Exception is \t" + e + " Occured inside Java File \t";
		if (logError.isErrorEnabled()) {
			logError.error(" [ERROR] " + text + " - " + filename);
			logError.error(e);
		}
	}

	public static void exceptionJava(java.lang.Exception e, String filename, String fname) {
		String text = "The Exception is \t" + e + " Occured inside Java File \t";
		if (logError.isErrorEnabled()) {
			logError.error(" [ERROR] " + text + " - " + filename+" - "+fname);
			logError.error(e);
		}

	}

	public static void exceptionSevier(java.lang.Exception e, String filename, String fname) {
		{
			if (logError.isErrorEnabled()) {
				logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The Sevier Exception is \t" + e + " Occured inside Java File \t" + filename+" - "+fname);
			}
		}
	}

	public static void exceptionMedium(java.lang.Exception e, String filename, String fname) {
		{
			if (logError.isErrorEnabled()) {
				logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The Medium Exception is \t" + e + " Occured inside Java File \t" + filename+" - "+fname);
			}

		}
	}

	/****************************************************************************************************
	 * Following is the method for writing SQL exceptions exclusively. Follwoing
	 * methode will be used to log the SQL exception occuring in any java file.
	 * fname is the filename in which exception is to be logged filename is the
	 * name of the file in which exception occured
	 ***************************************************************************************************/

	public static void exceptionSqlJava(java.sql.SQLException sqle, String filename, String fname) {

		if (logError.isErrorEnabled()) {
			logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + "[ERROR] The exception is  " + sqle + " Error Code " + sqle.getErrorCode() + " inside Java File " + filename+" - "+fname);
		}

		while ((sqle = sqle.getNextException()) != null) {
			if (logError.isErrorEnabled()) {
				logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The exception is  " + sqle + " Error Code " + sqle.getErrorCode() + " inside Java File " + filename+" - "+fname);
			}

		}

	}

	public static void exceptionSqlJsp(java.sql.SQLException sqle, String url, String filename) {

		if (logError.isErrorEnabled()) {
			logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The exception is " + sqle + " ErrorCode " + sqle.getErrorCode() + " at " + url + " inside JSP File " + filename);
		}

		while ((sqle = sqle.getNextException()) != null) {
			if (logError.isErrorEnabled()) {
				logError.error(new SimpleDateFormat("E MMM d H:mm:ss.SSSS z yyyy").format(new java.util.Date()) + " [ERROR] The exception is " + sqle + " ErrorCode " + sqle.getErrorCode() + " at " + url);
			}

		}
	}

}