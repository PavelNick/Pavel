package com.oodbcourse.com;

import com.db4o.*;
import com.db4o.config.EmbeddedConfiguration;

//точка входа в программу
public class Main {
	public static void main(String[] args) {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		
		// изменения в конфигурацию базы данных, для постоянного их обновления.
		
		config.common().objectClass(Book.class).cascadeOnUpdate(true);
		config.common().objectClass(User.class).cascadeOnUpdate(true);
		config.common().objectClass(Subscription.class).cascadeOnUpdate(true);
		
		ObjectContainer db = Db4oEmbedded.openFile(config, "Library");
		
		try {
			
			//отчистка базы
			DBManager.clearDb(db);
			
			// в следующей строке указывается путь до BaseInfo.json
			String JSONSource = "C:\\com\\BaseInfo.json";
			
			DBManager.fillDb(db, JSONSource);
			
		} finally {
			db.close();
		}
	}
}
