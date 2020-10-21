package antra.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCDriver {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        Scanner sc=new Scanner(System.in);
//		System.out.println("please enter id:");
//		int id=sc.nextInt();
//
//		System.out.println("please enter name:");
//		String name=sc.next();
//
//		System.out.println("please enter salary:");
//		int sal=sc.nextInt();

//        Driver driver = new com.mysql.jdbc.Driver();
//        Driver driver = new com.mysql.cj.jdbc.Driver();
        Class.forName("com.mysql.cj.jdbc.Driver");  //load static block

//        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=GMT","root","19950531");
        System.out.println(conn);
        Statement statement =conn.createStatement();
//        statement.executeUpdate("insert into employee values (10,'Hensby',20,1)");
        ResultSet res = statement.executeQuery("select * from employee");
        while (res.next()) {
            System.out.print(res.getInt(1) + " ");
            System.out.print(res.getString(2) + " ");
            System.out.print(res.getInt(3) + " ");
            System.out.println(res.getInt(4));
        }

        PreparedStatement ps = conn.prepareStatement("insert into employee values (?,?,?,?)");
            ps.setInt(1,8);
            ps.setString(2,"derrick");
            ps.setInt(3,29);
            ps.setInt(4,2);

            ps.execute();
        PreparedStatement ps2 = conn.prepareStatement("insert into employee values (?,?,?,?)");
            ps2.setInt(1,12);
            ps2.setString(2,"marry");
            ps2.setInt(3,29);
            ps2.setInt(4,2);
            ps2.addBatch();

            ps2.setInt(1,14);
            ps2.setString(2,"trump");
            ps2.setInt(3,29);
            ps2.setInt(4,2);
            ps2.addBatch();

        ps2.executeBatch();

        ResultSet newRes = statement.executeQuery("select * from employee");
        ResultSetMetaData ds = newRes.getMetaData();
        System.out.println(ds.getColumnName(1));
        System.out.println(ds.getColumnName(2));
        System.out.println(ds.getColumnTypeName(1));
        conn.close();

    }
}
