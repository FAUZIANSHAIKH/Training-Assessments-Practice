package com.utils.logging;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loginportal.editprofile.controller.ProfileController;
import com.loginportal.editprofile.model.User;

public class UserLogs {

	int logUserID;
	String logRole;
	StackTraceElement[] logFunctionName;
	public void fetchDetails(User user) {
		logUserID = user.getUserID();
		logRole = user.getUserRole();
		logFunctionName = Thread.currentThread().getStackTrace();
	}
	private static Logger logger = LoggerFactory.getLogger(ProfileController.class);
	public void logMethodEntryTrace(User user,String message,int logRequestCode,String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  RequestCode:" + logRequestCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
	}

	public void logMethodExitTrace(User user,String message, int logResponseCode, String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  ResponseCode:" + logResponseCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	public void logError(User user,String message, int logResponseCode, String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.error(message + "  ResponseCode:" + logResponseCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	public void logInfo(User user,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
	}
	public void IllegalArgumentException(User user,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	
	public void NoSuchElementException(int logUserID,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		logFunctionName = Thread.currentThread().getStackTrace();
		logger.info(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
}
