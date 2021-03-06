package co.jeju.jejuProject.review.vo;

import java.sql.Date;

public class ReviewVO extends ReviewCommentVO {
	private int rNo;
	private String rTitle;
	private String rContent;
	private String rWriter;
	private Date rDate;
	private int rHit;
	private int rAno;
	private int rLike;
	
	
	public ReviewVO() {
		super();
	}

	
	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getrHit() {
		return rHit;
	}

	public void setrHit(int rHit) {
		this.rHit = rHit;
	}

	public int getrAno() {
		return rAno;
	}

	public void setrAno(int rAno) {
		this.rAno = rAno;
	}

	public int getrLike() {
		return rLike;
	}

	public void setrLike(int rLike) {
		this.rLike = rLike;
	}
	
}
