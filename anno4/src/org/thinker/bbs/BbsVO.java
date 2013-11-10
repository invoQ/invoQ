package org.thinker.bbs;

import java.util.Date;

public class BbsVO {

	private Long bbsno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	public Long getBbsno() {
		return bbsno;
	}
	public void setBbsno(Long bbsno) {
		this.bbsno = bbsno;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BbsVO [bbsno=" + bbsno + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regDate=" + regDate + "]";
	}
	
}
