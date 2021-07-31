package co.jeju.jejuProject.review.vo;

import java.sql.Date;

public class CommentsVO {
	private int rNo;
	private int rcNo;
	private String rcContent;
	private String rcName;
	private Date rcDate;
	private int rcLike;
	
	
	public CommentsVO() {
		super();
	}

	
	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getRcNo() {
		return rcNo;
	}

	public void setRcNo(int rcNo) {
		this.rcNo = rcNo;
	}

	public String getRcContent() {
		return rcContent;
	}

	public void setRcContent(String rcContent) {
		this.rcContent = rcContent;
	}

	public String getRcName() {
		return rcName;
	}

	public void setRcName(String rcName) {
		this.rcName = rcName;
	}

	public Date getRcDate() {
		return rcDate;
	}

	public void setRcDate(Date rcDate) {
		this.rcDate = rcDate;
	}

	public int getRcLike() {
		return rcLike;
	}

	public void setRcLike(int rcLike) {
		this.rcLike = rcLike;
	}
	
}
