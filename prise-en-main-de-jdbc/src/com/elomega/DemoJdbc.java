package com.elomega;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DemoJdbc {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		try (FileInputStream file = new FileInputStream("model/conf.properties")) {
			props.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Class.forName( props.getProperty("jdbc.driver.class") );
	    String url = props.getProperty("jdbc.url");
	    String login = props.getProperty("jdbc.login");
	    String passworld = props.getProperty("jdbc.passworld");
	    
	    Connection connection = DriverManager.getConnection(url, login, passworld);
	    connection.close();
	    
	}

}
