package com.caveofprogramming.spring.test;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	private LogWriter consoleWriter;
	private LogWriter fileWriter;

	public void setConsoleWriter(LogWriter writer) {
		System.out.println("setConsoleWriter --------------> injecting consoleWriter");
		this.consoleWriter = writer;
	}

	public void setFileWriter(LogWriter fileWriter) {
		System.out.println("setFileWriter --------------> injecting fileWriter");
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

}
