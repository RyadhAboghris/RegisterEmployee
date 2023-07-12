/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL;

import DAL.DAL;
import Models.Employee;
import Models.Section;
import Models.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ryadh
 */
public class CLS_Employee {
    DAL dal;

    public CLS_Employee() {
        this.dal = DAL.getInstance();
    }

    
     public void addOne(String id,String name,String section,int phoneNumber,String email,String location,byte [] image) {
        try {
            dal.ps = dal.conn.prepareStatement("insert into tbl_employees(id,name,section,phone_number,email,location,image)values(?,?,?,?,?,?,?)");
            dal.ps.setString(1, id);
            dal.ps.setString(2, name);        
            dal.ps.setString(3, section);
            dal.ps.setInt(4, phoneNumber);
            dal.ps.setString(5 , email);
            dal.ps.setString(6, location);
             dal.ps.setBytes(7, image);    
            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
public void updateOne(String id,String name,String section,int phoneNumber,String email,String location,byte [] image,String oid) {
        try {
            dal.ps = dal.conn.prepareStatement("update tbl_employees set  id=? , name=? , section=? , phone_number=? , email=? , location=? , image=? where id=?");
             dal.ps.setString(1, id);
            dal.ps.setString(2, name);        
            dal.ps.setString(3, section);
            dal.ps.setInt(4, phoneNumber);
            dal.ps.setString(5 , email);
            dal.ps.setString(6, location);
             dal.ps.setBytes(7, image);    
             dal.ps.setString(8, oid);    
   
  
             

            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
    public ArrayList<Employee>  getAll() {
        try {
            dal.rs = dal.stmt.executeQuery("select * from tbl_employees");
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (dal.rs.next()) {
                employees.add(new Employee(dal.rs.getString("id"),dal.rs.getString("name"),dal.rs.getString("section"),dal.rs.getInt("phone_number"),dal.rs.getString("email"),dal.rs.getString("location"),dal.rs.getBytes("image")));
            }
            return employees;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteOne(String id) {
        try {
            dal.ps = dal.conn.prepareStatement("delete tbl_employees where id=?");
            dal.ps.setString(1, id);
            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
    
    public ArrayList<Employee> search(String str, int currentRow) {
        try {
/// where + user_name + name  like '%'+?+'%' order by user_name  offset ? rows fetch next 20 rows only
//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_employees where + id + name + section + email + location    like '%'+?+'%' order by id  offset ? rows fetch next 20 rows only");
            dal.ps.setString(1, str);
            dal.ps.setInt(2, currentRow);
            dal.rs = dal.ps.executeQuery();
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (dal.rs.next()) {
                employees.add(new Employee(dal.rs.getString("id"),dal.rs.getString("name"),dal.rs.getString("section"),dal.rs.getInt("phone_number"),dal.rs.getString("email"),dal.rs.getString("location"),dal.rs.getBytes("image")));
            }
            return employees;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("here");
        }
        return null;
    }
    
        public int amountOfRows(String str) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select count(id) as amount from tbl_employees where + id + name + section + email + location  like '%'+?+'%'  ");
            dal.ps.setString(1, str);
            dal.rs = dal.ps.executeQuery();
            while (dal.rs.next()) {
                return dal.rs.getInt("amount");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
        
        public Employee getOne(String name) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_employees where id=?");
            dal.ps.setString(1, name);
            dal.rs = dal.ps.executeQuery();
            while (dal.rs.next()) {
                return new Employee(dal.rs.getString("id"),dal.rs.getString("name"),dal.rs.getString("section"),dal.rs.getInt("phone_number"),dal.rs.getString("email"),dal.rs.getString("location"),dal.rs.getBytes("image"));
                        
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
         public boolean checkEmployeeIdName(String id) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_employees where id=?");
            dal.ps.setString(1, id);
            dal.rs = dal.ps.executeQuery();

            while (dal.rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
