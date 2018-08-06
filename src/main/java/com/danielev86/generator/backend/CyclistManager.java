package com.danielev86.generator.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielev86.generator.utility.EnviromentPropertyReader;

@Component
public class CyclistManager {

	@Autowired
	private EnviromentPropertyReader env;

	private final String databaseURL = "jdbc:ucanaccess://C:\\Users\\daniele\\Desktop\\PCM\\HannesConverter2009V0.9\\DB\\Database.mdb";

	public void getAllCyclist() {

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			String sql = "SELECT * FROM DYN_cyclist";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				String firstName = result.getString(env.getFieldFirstName());
				String lastName = result.getString(env.getFieldLastName());


				System.out.println(firstName + ", " + lastName);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public void updateCyclistInfo(String sqlQuery) {
		
		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
