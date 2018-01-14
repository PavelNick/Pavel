package model;

/**
 * Обычный java-класс для генерации данных пользователя в БД
 */
public class User {
	
	private int userNumb;
	private String initials;
	private String address;
	private long userPhoneNumber;
	
	public User(int userNumb, String initials, String address, long userPhoneNumber) {
		this.userNumb = userNumb;
		this.initials = initials;
		this.address = address;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	public int getUserNumb() {
		return userNumb;
	}
	public void setUserNumb(int userNumb) {
		this.userNumb = userNumb;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(long userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	@Override
	public String toString() {
		return "User [userNumb=" + userNumb + ", initials=" + initials + ", address=" + address + ", userPhoneNumber="
				+ userPhoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (initials == null) {
			if (other.initials != null)
				return false;
		} else if (!initials.equals(other.initials))
			return false;
		if (userNumb != other.userNumb)
			return false;
		if (userPhoneNumber != other.userPhoneNumber)
			return false;
		return true;
	}

}
