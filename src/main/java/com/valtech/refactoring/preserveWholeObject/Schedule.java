package com.valtech.refactoring.preserveWholeObject;

public class Schedule {
	private String _start;
	private String _end;
	private String _title;
	
	public Schedule(String start, String end, String title) {
		this._start = start;
		this._end = end;
		this._title = title;
	}
	
	public String getStart() {
		return _start;
	}
	public void setStart(String start) {
		this._start = start;
	}
	public String getEnd() {
		return _end;
	}
	public void setEnd(String end) {
		this._end = end;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
}
