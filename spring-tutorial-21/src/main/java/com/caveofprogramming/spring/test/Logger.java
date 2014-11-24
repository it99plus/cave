package com.caveofprogramming.spring.test;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	private LogWriter consoleWriter;
	private LogWriter fileWriter;
	
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		System.out.println("Logger construcor ------------> injecting consoleWriter, fileWriter");
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}

	public void setConsoleWriter(LogWriter writer) {
		this.consoleWriter = writer;
	}

	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}

}
