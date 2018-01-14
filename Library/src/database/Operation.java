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
	
	//метод создания первоначальных данных в базе
	public static void createData(ObjectContainer data) {
		//User(userNumb, initials, address, userPhoneNumber)
		User user = new User(10, "Петров Петр", "петрова 17", 9502554545L);
		data.store(user);
		User user2 = new User(11, "Иванов Иван", "ворошилова 12", 9122554545L);
		data.store(user2);
		User user3 = new User(12, "Сергеев Сергей", "пушкинская 3", 9062554545L);
		data.store(user3);
		User user4 = new User(13, "Вострова Мария", "автозаводская 23", 9503994545L);
		data.store(user4);
		User user5 = new User(14, "Ковальский Игорь", "удмуртская 122", 9502559545L);
		data.store(user5);
		User user6 = new User(15, "Архипова Евгения", "советская 44", 9502554111L);
		data.store(user6);
		User user7 = new User(16, "Стерхова Дарья", "майская 38", 9124568822L);
		data.store(user7);
		User user8 = new User(17, "Заводнова Клавдия", "холмогорова 2", 9512554545L);
		data.store(user8);
		User user9 = new User(18, "Першин Павел", "центральная 21", 9512551245L);
		data.store(user9);
		
		Book book = new Book("Капитал", 12, "Карл Маркс", parseYear("2001"), 450, 10, null, null);
		data.store(book);
		Book book2 = new Book("Происхождение", 121, "Дэн Браун", parseYear("2002"), 850, 4, parseDate("25-11-2017"), null);
		data.store(book2);
		Book book3 = new Book("Мятная сказка", 785, "Александр Полярный", parseYear("2001"), 500, 5, null, null);
		data.store(book3);
		Book book4 = new Book("Экскалибур", 155, "Бернард Корнуэлл", parseYear("2012"), 1450, 2, null, null);
		data.store(book4);
		Book book5 = new Book("Тобол. Много званных", 1238, "Алексей Иванов", parseYear("2010"), 2250, 1, parseDate("12-12-2017"), null);
		data.store(book5);
		Book book6 = new Book("Белгравия", 8544, "Феллоуз Дж.", parseYear("2011"), 400, 6, null, null);
		data.store(book6);
		Book book7 = new Book("Дебри", 354658, "Алексей Иванов", parseYear("2016"), 550, 1, parseDate("20-10-2017"), null);
		data.store(book7);
		Book book8 = new Book("Ирландия", 215616, "Эдвард Резерфорд", parseYear("2009"), 300, 2, null, null);
		data.store(book8);
		Book book9 = new Book("Лондон", 35455, "Эдвард Резерфорд", parseYear("2001"), 500, 1, parseDate("1-11-2017"), parseDate("20-12-2017"));
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
	
	//возвращаем в библиотеку книгу
	public static void returnBook(int userNum, int bookISBN, ObjectContainer data) {
		ObjectSet<Subscription> response = data.query(Subscription.class);
		Book b = getBookByISBN(bookISBN, data);
		User u = getUserByNumber(userNum, data);
		//ищем нашего пользователя который взял книгу
		while(response.hasNext()) {
			Subscription s = response.next();
			if (s.getBookInfo().equals(b) && s.getUserInfo().equals(u)) {
				s.setRetirement(false);
				//обновляем запись в базе, что книга возвращена
				data.store(s);
				b.setReceptionDate(Calendar.getInstance().getTime());
				//обновляем запись в какой дате книга возвращена
				data.store(b);
				System.out.println(u.getInitials() + " вернул(а) книгу " + b.getName());
				break;
			}
		}
	}
	
	//берем книгу из библиотеки
	public static void takeBook(int userNum, int bookISBN, ObjectContainer data) {
		User u = getUserByNumber(userNum, data);
		Book b = getBookByISBN(bookISBN, data);
		if (b.getCopiesNumber() == 0) {
			System.out.println(b.getName() + " такие книги закончились");
			return;
		}
		Subscription newSub = new Subscription(u, b, true);
		//создаем в базе новую запись что книга взята на руки
		data.store(newSub);
		b.setIssuesDate(Calendar.getInstance().getTime());
		b.setCopiesNumber(b.getCopiesNumber() - 1);
		//обновляем запись в книге в какое время ее взяли на руки
		data.store(b);
		System.out.println(u.getInitials() + " взял(а) книгу " + b.getName());
	}
	
	//получаем экземпляр книги по номеру ISBN
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
	
	//получаем экземпляр пользователя по номеру читательского
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
