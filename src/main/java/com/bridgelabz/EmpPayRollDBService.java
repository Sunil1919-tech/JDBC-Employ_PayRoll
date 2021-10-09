package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpPayRollDBService {
    /**
     * Declaring Main Method Here
     * For Getting The Connection Of DataBase
     */
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection;
        System.out.println("connecting to database : " + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection to the Database Successfully! :" + connection);
        return connection;
    }

    /**
     * retreiving the data from the database to get person salary
     */
    public List<EmpPayRollData> readData() {
        String sql = "select * from employee_payroll ";
        List<EmpPayRollData> employeePayRollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double basic_pay = result.getDouble("basic_pay");
                LocalDate startDate = result.getDate("start").toLocalDate();
                employeePayRollList.add(new EmpPayRollData(id, name, basic_pay, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayRollList;
    }
}

