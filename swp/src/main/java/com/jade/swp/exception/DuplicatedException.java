package com.jade.swp.exception;

public class DuplicatedException extends Exception {
	private static final long serialVersionUID = -388789975491524511L;
	
	private String msg;
	
	public DuplicatedException(Integer key) {
		this("t" + key);
	}

	public DuplicatedException(String tableName) {
		super(tableName);
		this.msg = tableName + " Key Duplicated!";
	}

	public String getMessage() {
		return this.msg;
	}
}
