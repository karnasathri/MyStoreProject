package com.mystore.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
 public	 static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello world \n");
		
		logger.info("This is information massege");
		logger.error("This is error massege");
		logger.warn("This is warn massege");
		logger.fatal("This is fatal massege");
		
		System.out.println("\n Complited");


		
	}

}
