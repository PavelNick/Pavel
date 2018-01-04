package com.oodbcourse.com;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

//Модуль запросов к базе данных
public class Queries {
	
	// Нахождение всех подписчиков по имени
	public static ObjectSet<Subscription> findSubscriptionsByInitals(ObjectContainer db, String Initials) {
		ObjectSet<Subscription> subscriptions = db.query(new Predicate<Subscription>() {
			public boolean match(Subscription subscription) {
				return subscription.getUser().getInitials().equals(Initials);
			}
		});
		
		return subscriptions;
	}
	


	// Нахождение подсписчика по его имени
	public static ObjectSet<User> findUserByInitials(ObjectContainer db, String Initials) {
		ObjectSet<User> users = db.query(new Predicate<User>() {
			public boolean match(User) {
				return User.getInitials().equals(Initials);
			}
		});
		
		return users;
	}
	
	// Нахождение подписки по дате выбытия (возврата книги)
	public static ObjectSet<Subscription> findSubscriptionByretirement(ObjectContainer db, Integer retirement) {
		ObjectSet<Subscription> subscriptions = db.query(new Predicate<Subscription>() {
			public boolean match(Subscription oldSubscription) {
				return oldSubscription.getretirement().getretirement().equals(newretirement);
			}
		});
		
		return subscriptions;
	}

	
	
}
