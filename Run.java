import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import database.Operation;
import model.Subscription;

public class Run {
	
	static ObjectContainer data;
	
	public static void main(String[] args) {
		
		try {
			data = Db4oEmbedded.openFile("library");
			
			//������� �������������� ������, ����� ������� ���� ���
			//����� ������ ��� ����� ������������ ���� � ���� ������
			Operation.createData(data);
			
			//����������� ��� ������ � ����
			printAllData();
			
			//������� �� ���������� ���� ���� � ������� ���������
			Operation.takeBook(18, 12, data);
			Operation.takeBook(15, 785, data);
			
			printOrders();
			
			//� ������ ���� �� ���� � ������� ���������
			Operation.returnBook(15, 785, data);
			
			printOrders();
			
		} finally {
			data.close();
		}
		
	}
	
	public static void printAllData() {
		System.out.println("-----------------��� ������ � ��--------------------");
		ObjectSet<Object> d = data.query().execute();
		d.forEach(System.out::println);
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	public static void printOrders() {
		System.out.println("-----------------��� ������ ��� ���� �����--------------------");
		Query q = data.query();
		q.constrain(Subscription.class);
		ObjectSet<Subscription> sub = q.execute();
		sub.forEach(System.out::println);
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}

}
