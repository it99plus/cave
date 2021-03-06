package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;
	
	
	/* if required is set to false and the bean is not defined in the 
     file, the compiler  will not attempt to inject - but if it is 
     true than the compiler will complain with BeanCreationException */
	@Autowired(required=false) 
	@Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	@Qualifier("filewriter")
	public void setFileWriter(LogWriter fileWriter) {
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
