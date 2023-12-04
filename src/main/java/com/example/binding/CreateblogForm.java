package com.example.binding;

import lombok.Data;

@Data
public class CreateblogForm {

	private String posttitleCnt;
	
	private String postshortdescriptionCnt;
	


	public String getPosttitleCnt() {
		return posttitleCnt;
	}

	public void setPosttitleCnt(String posttitleCnt) {
		this.posttitleCnt = posttitleCnt;
	}

	public String getPostshortdescriptionCnt() {
		return postshortdescriptionCnt;
	}

	public void setPostshortdescriptionCnt(String postshortdescriptionCnt) {
		this.postshortdescriptionCnt = postshortdescriptionCnt;
	}

	

	@Override
	public String toString() {
		return "CreateblogForm [posttitleCnt=" + posttitleCnt + ", postshortdescriptionCnt=" + postshortdescriptionCnt +  "]";
	}
	
	
	
}
