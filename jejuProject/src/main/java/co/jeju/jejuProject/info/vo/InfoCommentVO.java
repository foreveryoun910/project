package co.jeju.jejuProject.info.vo;

import java.sql.Date;

public class InfoCommentVO {
	private int iNo;
	private int icNo;
	private String icContent;
	private String icName;
	private Date icDate;
	
	
	public InfoCommentVO() {
		super();
	}

	
	public int getiNo() {
		return iNo;
	}

	public void setiNo(int iNo) {
		this.iNo = iNo;
	}

	public int getIcNo() {
		return icNo;
	}

	public void setIcNo(int icNo) {
		this.icNo = icNo;
	}

	public String getIcContent() {
		return icContent;
	}

	public void setIcContent(String icContent) {
		this.icContent = icContent;
	}

	public String getIcName() {
		return icName;
	}

	public void setIcName(String icName) {
		this.icName = icName;
	}

	public Date getIcDate() {
		return icDate;
	}

	public void setIcDate(Date icDate) {
		this.icDate = icDate;
	}
	
}
