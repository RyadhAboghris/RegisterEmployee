/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ryadh
 */
public class DAL {

    String DB_URL = "jdbc:sqlserver://RYADHABOGHRIS;database=FTDATA;encrypt=true;trustServerCertificate=true";
    String USER = "IAdminB";
    String PASS = "123";
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public PreparedStatement ps;
    private volatile static DAL uniqueInstance;

    private DAL() {
        open();
    }

    public static DAL getInstance() {
        if (uniqueInstance == null) {
            synchronized (DAL.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new DAL();
                }
            }
        }
        return uniqueInstance;
    }

    public void open() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readStatement(String sql) {
        try {
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("error in readStatement");

        }

    }

    public ResultSet excuteStatement(String sql) {
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("user_name"));

            }
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public void readPreparedStatement(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate(sql);
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ResultSet excutePreparedStatement(String sql, PreparedStatement preparedStatement) {
        try {
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
}
