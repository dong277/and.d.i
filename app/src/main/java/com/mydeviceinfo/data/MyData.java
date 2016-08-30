package com.mydeviceinfo.data;

public class MyData {

	public MyData(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;
	private String content;
}