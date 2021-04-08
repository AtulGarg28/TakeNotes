package com.atul.model;

import java.util.Date;

public class Note {
	
	private int nid;
	private int uid;
	private String title;
	private String content;
	private Date date;
	
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Note [nid=" + nid + ", uid=" + uid + ", title=" + title + ", content=" + content + ", date=" + date
				+ "]";
	}
}
