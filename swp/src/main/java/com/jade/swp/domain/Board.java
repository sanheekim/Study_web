package com.jade.swp.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int replycnt;
	private String[] files;

	public Board() {
	}

	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

}
