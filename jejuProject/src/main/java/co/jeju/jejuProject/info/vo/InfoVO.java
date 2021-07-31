package co.jeju.jejuProject.info.vo;

import java.sql.Date;

public class InfoVO {
	private int iNo;
	private String iSubject; // 말머리
	private String iTitle;
	private String iContent;
	private String iWriter;
	private Date iDate;
	private int iHit;
	private int iLike;
	private int iRecommend;
	private int iAno;
	
	
	public InfoVO() {
		super();
	}

	
	public int getiNo() {
		return iNo;
	}

	public void setiNo(int iNo) {
		this.iNo = iNo;
	}

	public String getiSubject() {
		return iSubject;
	}

	public void setiSubject(String iSubject) {
		this.iSubject = iSubject;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}

	public String getiWriter() {
		return iWriter;
	}

	public void setiWriter(String iWriter) {
		this.iWriter = iWriter;
	}

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}

	public int getiHit() {
		return iHit;
	}

	public void setiHit(int iHit) {
		this.iHit = iHit;
	}

	public int getiLike() {
		return iLike;
	}

	public void setiLike(int iLike) {
		this.iLike = iLike;
	}

	public int getiRecommend() {
		return iRecommend;
	}

	public void setiRecommend(int iRecommend) {
		this.iRecommend = iRecommend;
	}

	public int getiAno() {
		return iAno;
	}

	public void setiAno(int iAno) {
		this.iAno = iAno;
	}
	
}
