package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;
	
	
	/* if required is set to false and the bean is not defined in the 
     file, the compiler  will not attempt to inject - but if it is 
     true than the compiler will complain with BeanCreationException */
	@Autowired(required=true) 
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {  
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		if (consoleWriter != null)
		    consoleWriter.write(text);
	}

}
