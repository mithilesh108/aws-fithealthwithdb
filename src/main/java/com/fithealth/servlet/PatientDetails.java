package com.fithealth.servlet;

public class PatientDetails {

	private int id;
	private String fullName = null;
	private String mobileNo = null;
	private String emailAddress = null;
	private int age = 0;
	private  String gender = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "PatientDetails [id=" + id + ", fullName=" + fullName + ", mobileNo=" + mobileNo + ", emailAddress="
				+ emailAddress + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
