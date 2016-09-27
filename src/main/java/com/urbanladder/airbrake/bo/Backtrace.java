package com.urbanladder.airbrake.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * To capture stack trace line details
 * 
 * @author salonegupta@gmail.com
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Backtrace {

	@JsonProperty(value = "backtrace")
	private List<Line> lines;

	public Backtrace() {
		lines = new ArrayList<>();
	}

	public Backtrace(StackTraceElement[] stackTraceElements) {
		this();

		for (StackTraceElement stackTraceElement : stackTraceElements) {
			String fileName = stackTraceElement.getFileName();
			String methodName = stackTraceElement.getMethodName();
			int lineNumber = stackTraceElement.getLineNumber();

			if (stackTraceElement.isNativeMethod()) {
				lineNumber = -1;
			}

			Line line = new Line(fileName, lineNumber, methodName);
			lines.add(line);
		}
	}

	public List<Line> getLines() {
		return lines;
	}

	@Override
	public String toString() {
		return "Backtrace [lines=" + lines + "]";
	}

	@JsonInclude(Include.NON_EMPTY)
	public static class Line {
		private String file;

		private int line;

		private String function;

		public Line(String file, int line, String function) {
			this.file = file;
			this.line = line;
			this.function = function;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public int getLine() {
			return line;
		}

		public void setLine(int line) {
			this.line = line;
		}

		public String getFunction() {
			return function;
		}

		public void setFunction(String function) {
			this.function = function;
		}

		@Override
		public String toString() {
			return "Line [file=" + file + ", line=" + line + ", function=" + function + "]";
		}

	}
}
