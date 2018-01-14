package model;

/**
 * Обычный java-класс для генерации данных кто какие книги взял в БД
 */
public class Subscription {
	
	private User userInfo;
	private Book bookInfo;
	private boolean retirement; //флаг закрытия подписки true - на руках, иначе нет
	
	public Subscription(User userInfo, Book bookInfo, boolean retirement) {
		this.userInfo = userInfo;
		this.bookInfo = bookInfo;
		this.retirement = retirement;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public Book getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Book bookInfo) {
		this.bookInfo = bookInfo;
	}

	public boolean isRetirement() {
		return retirement;
	}

	public void setRetirement(boolean retirement) {
		this.retirement = retirement;
	}

	@Override
	public String toString() {
		String s = retirement ? "На руках" : "Была возвращена";
		return "Subscription [userInfo=" + userInfo.getInitials() + ", bookInfo=" + bookInfo.getName()
				+ ", retirement=" + s + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (bookInfo == null) {
			if (other.bookInfo != null)
				return false;
		} else if (!bookInfo.equals(other.bookInfo))
			return false;
		if (retirement != other.retirement)
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		return true;
	}
}
