package com.example.binding;

import lombok.Data;

@Data
public class ViewblogForm {
	
	private String nameCnt;

    private String emailCnt;
	
	private String commentCnt;

	public String getNameCnt() {
		return nameCnt;
	}

	public void setNameCnt(String nameCnt) {
		this.nameCnt = nameCnt;
	}

	public String getEmailCnt() {
		return emailCnt;
	}

	public void setEmailCnt(String emailCnt) {
		this.emailCnt = emailCnt;
	}

	public String getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "ViewblogForm [nameCnt=" + nameCnt + ", emailCnt=" + emailCnt + ", commentCnt=" + commentCnt + "]";
	}

	
	
    
	
	
	
	
}
