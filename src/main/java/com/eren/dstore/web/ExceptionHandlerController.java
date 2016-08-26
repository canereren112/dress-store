package com.eren.assignment.sahibinden.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eren.assignment.sahibinden.exception.ResponseCodes;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.exception.ServiceRuntimeException;



/**
 * Exception Handler for Controllers
 * 
 * @author firat.eren
 *
 */
public class ExceptionHandlerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);
	/**
	 * Handle ServiceRuntimeException exception
	 * 
	 * @param req
	 * @param ex
	 * @return ServiceError object
	 */
	@ExceptionHandler(ServiceRuntimeException.class)
	@ResponseBody
	public ServiceResponse handleServiceRuntimeException(HttpServletRequest req, Exception ex) {
		LOGGER.error("Error during process request", ex);
		ServiceResponse error = new ServiceResponse((ServiceRuntimeException) ex);
		return error;
	}

	/**
	 * Handle unhandled exceptions
	 * 
	 * @param req
	 * @param ex
	 * @return exception message
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ServiceResponse handleUnexpectedException(HttpServletRequest req, Exception ex) {
		LOGGER.error("Error during process request", ex);
		ServiceResponse error = new ServiceResponse(ResponseCodes.ERROR);
		return error;
	}
	
	


}