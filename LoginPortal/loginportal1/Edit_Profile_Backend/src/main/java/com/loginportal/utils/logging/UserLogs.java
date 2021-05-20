package com.loginportal.utils.logging;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loginportal.editprofile.controller.ProfileController;
import com.loginportal.editprofile.model.User;

public class UserLogs {

	int logUserID;
	String logRole;
	StackTraceElement[] logFunctionName;
	public void fetchDetails(Optional<User> user) {
		logUserID = user.get().getUserID();
		logRole = user.get().getUserRole();
		logFunctionName = Thread.currentThread().getStackTrace();
	}
	private static Logger logger = LoggerFactory.getLogger(ProfileController.class);
	public void logMethodEntryTrace(Optional<User> user,String message,int logRequestCode,String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  RequestCode:" + logRequestCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
	}

	public void logMethodExitTrace(Optional<User> user,String message, int logResponseCode, String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  ResponseCode:" + logResponseCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	public void logError(Optional<User> user,String message, int logResponseCode, String logRequestMapping, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.error(message + "  ResponseCode:" + logResponseCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " RequestType:" + logRequestMapping + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	public void logInfo(Optional<User> user,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.info(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
	}
	public void illegalArgumentException(Optional<User> user,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		fetchDetails(user);
		logger.error(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + "  Role:"+ logRole + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
	
	public void noSuchElementException(int logUserID,String message,int logStatusCode, String logUserIP, String logUserDeviceDetails) {
		logFunctionName = Thread.currentThread().getStackTrace();
		logger.error(message + "  ResponseCode:" + logStatusCode + "  UserID:" + logUserID + " "+ " Class&Function:" + logFunctionName[2] + " " + " IPaddress:" + logUserIP + " "+ " DeviceDetails:" + logUserDeviceDetails);	
}
}
