package com.oodbcourse.com;

public class Book {
	private String bookName;
	private Integer ISBN;
	private String Author;
	private Date publicationYear;
	private Integer Price;
	private Integer copiesNumber;
	private Date issuesDate;
	private Date receptionDate;

	
	public Book(String bookName, Integer ISBN, String Author, Date publicationYear, Integer Price, Integer copiesNumber, Date issuesDate, Date receptionDate) {
		this.bookName = bookName;
		this.ISBN = ISBN;
		this.Author = Author;
		this.publicationYear = publicationYear;
		this.Price = Price;
		this.copiesNumber = copiesNumber;
		this.issuesDate = issuesDate;
		this.receptionDate = receptionDate;

	}
	
	public String getbookName() {
		return this.pairPhoneNumber;
	}
		
	public Integer getISBN() {
		return this.ISBN;
	}
		
	public String getAuthor() {
		return this.Author;
	}
	
	public Date publicationYear() {
		return this.publicationYear();
	}
	public Integer Price() {
		return this.Price();
	}
	public Integer copiesNumber() {
		return this.copiesNumber();
	}
	public Date issuesDate() {
		return this.issuesDate();
	}
	public Date receptionDate() {
		return this.receprionDate();
	}
		public String toString() {
		return this.bookName+" : "+this.ISBN+" : "this.Author+" : "+this.publicationYear+" : "this.Price+" : "+this.copiesNumber+" : "this.issuesDate+" : "+this.receptionDate+";
	}
}
