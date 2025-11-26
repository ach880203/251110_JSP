package com.saeyan.dto;

public class NoticeVO {
	
	/*
	 * num int primary key auto_increment,
		pass varchar(30) not null, 
		title varchar(30) , 
		date varchar (30),
		views int default 0,
		text TEXT (50)
	 */
	private int num;	
	private String pass;
	private String title;
	private String date;
	private String	views;
	private String text;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "NoticeVO [num=" + num + ", pass=" + pass + ", title=" + title + ", date=" + date + ", views=" + views
				+ ", text=" + text + "]";
	}
	
	
	
	
}
