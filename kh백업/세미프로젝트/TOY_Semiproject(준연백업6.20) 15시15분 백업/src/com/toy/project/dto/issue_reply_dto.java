package com.toy.project.dto;

public class issue_reply_dto {

	private int issue_num;
	private String user_nickname;
	private String reply_content;
	private String reply_date_create;

	public issue_reply_dto() {
		super();
	}

	public issue_reply_dto(int issue_num, String user_nickname, String reply_content, String reply_date_create) {
		super();
		this.issue_num = issue_num;
		this.user_nickname = user_nickname;
		this.reply_content = reply_content;
		this.reply_date_create = reply_date_create;
	}

	public int getIssue_num() {
		return issue_num;
	}

	public void setIssue_num(int issue_num) {
		this.issue_num = issue_num;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_date_create() {
		return reply_date_create;
	}

	public void setReply_date_create(String reply_date_create) {
		this.reply_date_create = reply_date_create;
	}

}
