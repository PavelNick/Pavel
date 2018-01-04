package com.oodbcourse.com;
import java.util.Date;

//Класс Subscription описывает подписку пользователя на книгу. В полях класса находятся объекты Book и User.
//Также к подписке прикрепляется дата выбытия (то есть дата возврата книги).

public class Subscription {
	private Book bookInfo;
	private User userInfo;
	private RetirementDate retirement;
	
	public Subscription(Book bookInfo, User userInfo, retirementDate retirement) {
		this.Book = bookInfo;
		this.User = userInfo;
		this.RetirementDate = retirement;
	}
	
	public Book getBook() {
		return this.bookInfo;
	}
	
	public void setBook(Book bookInfo) {
		this.bookInfo = bookInfo;
	}
	
	public RetirementDate getretirement() {
		return this.retirement;
	}
	
	public User getuserInfo() {
		return this.userInfo;
	}
	
	public void setUser(User userInfo) {
		this.userInfo = userInfo;
	}
	
	public String toString() {
		return this.userInfo.getName() + " user information " + this.userInfo.getuserInfo().toString();
	}
}
