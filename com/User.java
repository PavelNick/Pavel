package com.oodbcourse.com;

//Класс User описывает пользователя книги. Поля имени, адреса, номера пользователя и его имя, фамилия, отчество.

public class User {
	private Integer userNumb;
	private String initials;
	private String adress;
	private Integer userPhonenumber;
	
	public User(Integer userNumb, String initials, String adress, Integer userPhonenumber) {
		this.userNumb = userNumb;
		this.initials = initials;
		this.address = address;
		this.userPhonenumber = userPhonenumber;
	}
	
	public Integer getuserNumb() {
		return userNumb;
	}
	
	public String getinitials() {
		return initials;
	}
	
	public String getadress() {
		return adress;
	}
	
		public Integer getuserPhonenumber() {
		return userPhonenumber;
	}
	
	public void setuserNumb(Integer userNumb) {
		this.name = userNumb;
	}
	
	public void setinitials(String initials) {
		this.note = initials;
	}
	
	public void setadress(String adress) {
		this.adress = adress;
	}
	
		public void setuserPhonenumber(Integer userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}
	
	public String toString() {
		return this.initials+" : "+this.address+" : "this.userNumb+" : "+this.userPhonenumber+";
	}
	
}
