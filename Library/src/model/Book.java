package model;

import java.util.Date;

/**
 * Обычный java-класс для генерации данных книг в БД
 */
public class Book {
	
	private String name;
	private int ISBN;
	private String author;
	private Date publicationDate;
	private int price;
	private int copiesNumber;
	private Date issuesDate; //дата выпуска
	private Date receptionDate; //дата приема
	
	public Book(String name, int iSBN, String author, Date publicationDate, int price, int copiesNumber,
			Date issuesDate, Date receptionDate) {
		this.name = name;
		ISBN = iSBN;
		this.author = author;
		this.publicationDate = publicationDate;
		this.price = price;
		this.copiesNumber = copiesNumber;
		this.issuesDate = issuesDate;
		this.receptionDate = receptionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCopiesNumber() {
		return copiesNumber;
	}

	public void setCopiesNumber(int copiesNumber) {
		this.copiesNumber = copiesNumber;
	}

	public Date getIssuesDate() {
		return issuesDate;
	}

	public void setIssuesDate(Date issuesDate) {
		this.issuesDate = issuesDate;
	}

	public Date getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", ISBN=" + ISBN + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", price=" + price + ", copiesNumber=" + copiesNumber + ", issuesDate=" + issuesDate
				+ ", receptionDate=" + receptionDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (copiesNumber != other.copiesNumber)
			return false;
		if (issuesDate == null) {
			if (other.issuesDate != null)
				return false;
		} else if (!issuesDate.equals(other.issuesDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		if (receptionDate == null) {
			if (other.receptionDate != null)
				return false;
		} else if (!receptionDate.equals(other.receptionDate))
			return false;
		return true;
	}

}
