package es.mordor.mordorLloguer.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MyDataSource {

	private static String defaultProperties = "db.properties";

	public static DataSource getMySQLDataSource() {

		MysqlDataSource ds = null;

		Properties prop = new Properties();

		try (FileInputStream fis = new FileInputStream(defaultProperties)) {

			prop.load(fis);

			ds = new MysqlDataSource();
			ds.setUrl(prop.getProperty("MYSQL_DB_URL"));
			ds.setUser(prop.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(prop.getProperty("MYSQL_DB_PASSWORD"));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return ds;

	}

}
