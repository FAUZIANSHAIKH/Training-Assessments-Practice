package com.utils.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loginportal.admin.controller.AdminController;

public class UserLogs {

	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

	public void logMethodEntryTrace(String message, int logRequestCode, String logRequestMapping, String logUserIP,
			String logUserDeviceDetails) {
		String logRole = "Admin";
		StackTraceElement[] logFunctionName = Thread.currentThread().getStackTrace();
		logger.info(message + "  RequestCode:" + logRequestCode + "  Role:" + logRole + " " + " Class&Function:"
				+ logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "
				+ " DeviceDetails:" + logUserDeviceDetails);
	}

	public void logMethodExitTrace(String message, int logResponseCode, String logRequestMapping, String logUserIP,
			String logUserDeviceDetails) {
		String logRole = "Admin";
		StackTraceElement[] logFunctionName = Thread.currentThread().getStackTrace();
		logger.info(message + "  ResponseCode:" + logResponseCode + "  Role:" + logRole + " " + " Class&Function:"
				+ logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "
				+ " DeviceDetails:" + logUserDeviceDetails);
	}

	public void logError(String message, int logResponseCode, String logRequestMapping, String logUserIP,
			String logUserDeviceDetails) {
		String logRole = "Admin";
		StackTraceElement[] logFunctionName = Thread.currentThread().getStackTrace();
		logger.error(message + "  ResponseCode:" + logResponseCode + "  Role:" + logRole + " " + " Class&Function:"
				+ logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "
				+ " DeviceDetails:" + logUserDeviceDetails);
	}

	public void logInfo(String message, int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		String logRole = "Admin";
		StackTraceElement[] logFunctionName = Thread.currentThread().getStackTrace();
		logger.info(message + "  ResponseCode:" + logStatusCode + "  Role:" + logRole + " " + " Class&Function:"
				+ logFunctionName[2] + " " + " IPaddress:" + logUserIP + " " + " DeviceDetails:"
				+ logUserDeviceDetails);
	}

}