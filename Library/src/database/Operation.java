package database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import model.Book;
import model.Subscription;
import model.User;

public class Operation {
	
	//����� �������� �������������� ������ � ����
	public static void createData(ObjectContainer data) {
		//User(userNumb, initials, address, userPhoneNumber)
		User user = new User(10, "������ ����", "������� 17", 9502554545L);
		data.store(user);
		User user2 = new User(11, "������ ����", "���������� 12", 9122554545L);
		data.store(user2);
		User user3 = new User(12, "������� ������", "���������� 3", 9062554545L);
		data.store(user3);
		User user4 = new User(13, "�������� �����", "������������� 23", 9503994545L);
		data.store(user4);
		User user5 = new User(14, "���������� �����", "���������� 122", 9502559545L);
		data.store(user5);
		User user6 = new User(15, "�������� �������", "��������� 44", 9502554111L);
		data.store(user6);
		User user7 = new User(16, "�������� �����", "������� 38", 9124568822L);
		data.store(user7);
		User user8 = new User(17, "��������� �������", "����������� 2", 9512554545L);
		data.store(user8);
		User user9 = new User(18, "������ �����", "����������� 21", 9512551245L);
		data.store(user9);
		
		Book book = new Book("�������", 12, "���� �����", parseYear("2001"), 450, 10, null, null);
		data.store(book);
		Book book2 = new Book("�������������", 121, "��� �����", parseYear("2002"), 850, 4, parseDate("25-11-2017"), null);
		data.store(book2);
		Book book3 = new Book("������ ������", 785, "��������� ��������", parseYear("2001"), 500, 5, null, null);
		data.store(book3);
		Book book4 = new Book("����������", 155, "������� ��������", parseYear("2012"), 1450, 2, null, null);
		data.store(book4);
		Book book5 = new Book("�����. ����� �������", 1238, "������� ������", parseYear("2010"), 2250, 1, parseDate("12-12-2017"), null);
		data.store(book5);
		Book book6 = new Book("���������", 8544, "������� ��.", parseYear("2011"), 400, 6, null, null);
		data.store(book6);
		Book book7 = new Book("�����", 354658, "������� ������", parseYear("2016"), 550, 1, parseDate("20-10-2017"), null);
		data.store(book7);
		Book book8 = new Book("��������", 215616, "������ ���������", parseYear("2009"), 300, 2, null, null);
		data.store(book8);
		Book book9 = new Book("������", 35455, "������ ���������", parseYear("2001"), 500, 1, parseDate("1-11-2017"), parseDate("20-12-2017"));
		data.store(book9);
		
		Subscription order = new Subscription(user, book5, false);
		data.store(order);
		Subscription order2 = new Subscription(user5, book2, false);
		data.store(order2);
		Subscription order3 = new Subscription(user2, book7, false);
		data.store(order3);
		Subscription order4 = new Subscription(user3, book9, false);
		data.store(order4);
	}
	
	//���������� � ���������� �����
	public static void returnBook(int userNum, int bookISBN, ObjectContainer data) {
		ObjectSet<Subscription> response = data.query(Subscription.class);
		Book b = getBookByISBN(bookISBN, data);
		User u = getUserByNumber(userNum, data);
		//���� ������ ������������ ������� ���� �����
		while(response.hasNext()) {
			Subscription s = response.next();
			if (s.getBookInfo().equals(b) && s.getUserInfo().equals(u)) {
				s.setRetirement(false);
				//��������� ������ � ����, ��� ����� ����������
				data.store(s);
				b.setReceptionDate(Calendar.getInstance().getTime());
				//��������� ������ � ����� ���� ����� ����������
				data.store(b);
				System.out.println(u.getInitials() + " ������(�) ����� " + b.getName());
				break;
			}
		}
	}
	
	//����� ����� �� ����������
	public static void takeBook(int userNum, int bookISBN, ObjectContainer data) {
		User u = getUserByNumber(userNum, data);
		Book b = getBookByISBN(bookISBN, data);
		if (b.getCopiesNumber() == 0) {
			System.out.println(b.getName() + " ����� ����� �����������");
			return;
		}
		Subscription newSub = new Subscription(u, b, true);
		//������� � ���� ����� ������ ��� ����� ����� �� ����
		data.store(newSub);
		b.setIssuesDate(Calendar.getInstance().getTime());
		b.setCopiesNumber(b.getCopiesNumber() - 1);
		//��������� ������ � ����� � ����� ����� �� ����� �� ����
		data.store(b);
		System.out.println(u.getInitials() + " ����(�) ����� " + b.getName());
	}
	
	//�������� ��������� ����� �� ������ ISBN
	private static Book getBookByISBN(Integer ISBN, ObjectContainer data) {
		ObjectSet<Book> books = data.query(Book.class);
		while (books.hasNext()) {
			Book book = books.next();
			if (book.getISBN() == ISBN) {
				return book;
			}
		}
		return null;
	}
	
	//�������� ��������� ������������ �� ������ �������������
	private static User getUserByNumber(Integer number, ObjectContainer data) {
		ObjectSet<User> users = data.query(User.class);
		while (users.hasNext()) {
			User user = users.next();
			if (user.getUserNumb() == number) {
				return user;
			}
		}
		return null;
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseYear(String date) {
		try {
			return new SimpleDateFormat("yyyy").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}
