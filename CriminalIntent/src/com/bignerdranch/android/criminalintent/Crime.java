package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public Crime() {
	// Генерирование уникального идентификатора
		mId = UUID.randomUUID();
		mDate = new Date();
	}
	public UUID getmId() {
		return mId;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmTitle() {
		return mTitle;
	}
	public Date getDate() {
		return mDate;
	}
	public void setDate(Date date) {
		mDate = date;
	}
	public boolean isSolved() {
		return mSolved;
	}
	public void setSolved(boolean solved) {
		mSolved = solved;
	}
	@Override
	public String toString() {
		return mTitle;		
	}
}
