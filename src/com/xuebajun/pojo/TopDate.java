package com.xuebajun.pojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// ʹ�������ܵ�������Ϊ����Top���еı�׼
public class TopDate {
	private Date now = new Date();
	private Date begin;
	private Date end ;
	
	
	public TopDate() {
		Calendar c = Calendar.getInstance(); 
		c.setTime(now);
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	    begin = c.getTime();
	    c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	    end = c.getTime();
	}
	
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Date getNow() {
		return now;
	}
	public void setNow(Date now) {
		this.now = now;
	}
}
