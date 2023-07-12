

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL;

import DAL.DAL;
import Models.User;
import java.util.ArrayList;

/**
 *
 * @author ryadh
 */
public class CLS_User {

    DAL dal;

    public CLS_User() {
        this.dal = DAL.getInstance();
    }

    public void addOne(String userName, String name, String password,String role, byte[] image,int active) {
        try {
            dal.ps = dal.conn.prepareStatement("insert into tbl_users(user_name,name,password,role,image,active)values(?,?,?,?,?,?)");
            dal.ps.setString(1, userName);
            dal.ps.setString(2, name);
            dal.ps.setString(3, password);   
            dal.ps.setString(4, role);
            dal.ps.setBytes(5, image);    
            dal.ps.setInt(6, active);


            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }


    /*select Acc_No, Acc_Parent_No, Acc_Aname, Acc_Type, Acc_Report, Acc_Level, Acc_Debit, Acc_Credit, Acc_Balance from tbl_Accountes
where
+ CONVERT(nvarchar,Acc_No)
+ Acc_Aname
like '%'+@txt+'%' */
    public void updateOne(String userName, String name, String password,String role, byte[] image,int active,String cUserName) {
        try {
            dal.ps = dal.conn.prepareStatement("update tbl_users set user_name=? , name=? , password=? , role=? , image=? , active=? where user_name=?");
            dal.ps.setString(1, userName);
            dal.ps.setString(2, name);
            dal.ps.setString(3, password);   
            dal.ps.setString(4, role);
            dal.ps.setBytes(5, image);    
            dal.ps.setInt(6, active);   
            dal.ps.setString(7, cUserName);

            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }

    public ArrayList<User> getAll() {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.rs = dal.stmt.executeQuery("select * from tbl_users");
            ArrayList<User> users = new ArrayList<User>();
            while (dal.rs.next()) {
                users.add(new User(dal.rs.getString("user_name"), dal.rs.getString("name"), dal.rs.getString("password")
                        ,dal.rs.getString("role") 
                        ,dal.rs.getBytes("image")
                        ,dal.rs.getInt("active")));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getOne(String userName) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_users where user_name=?");
            dal.ps.setString(1, userName);
            dal.rs = dal.ps.executeQuery();
            while (dal.rs.next()) {
                return new User(dal.rs.getString("user_name"), dal.rs.getString("name"), dal.rs.getString("password"),dal.rs.getString("role"), dal.rs.getBytes("image"),
                        dal.rs.getInt("active"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean checkUserName(String userName) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_users where user_name=?");
            dal.ps.setString(1, userName);
            dal.rs = dal.ps.executeQuery();

            while (dal.rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    
    public User login(String userName,String password) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_users where user_name=? and password=?");
            dal.ps.setString(1, userName);     
            dal.ps.setString(2, password);
            dal.rs = dal.ps.executeQuery();

            while (dal.rs.next()) {
                  return new User(dal.rs.getString("user_name"), dal.rs.getString("name"), dal.rs.getString("password"),dal.rs.getString("role"), dal.rs.getBytes("image"),
                        dal.rs.getInt("active"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
//            dal.ps = dal.conn.prepareStatement("select count(id) as amount from tbl_users where + convert(nvarchar,id) + name + age like '%'+?+'%'  ");

    public int amountOfRows(String str) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select count(user_name) as amount from tbl_users where + user_name + name  like '%'+?+'%'  ");
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

    public ArrayList<User> search(String str, int currentRow) {
        try {
/// where + user_name + name  like '%'+?+'%' order by user_name  offset ? rows fetch next 20 rows only
//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_users where + user_name + name  like '%'+?+'%' order by user_name  offset ? rows fetch next 20 rows only");
            dal.ps.setString(1, str);
            dal.ps.setInt(2, currentRow);
            dal.rs = dal.ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (dal.rs.next()) {
                users.add(new User(dal.rs.getString("user_name"), 
                        dal.rs.getString("name"),
                        dal.rs.getString("password"),
                        dal.rs.getString("role"),
                        dal.rs.getBytes("image"),
                        dal.rs.getInt("active")));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("here");
        }
        return null;
    }

    public void deleteOne(String userName) {
        try {
            dal.ps = dal.conn.prepareStatement("delete tbl_users where user_name=?");
            dal.ps.setString(1, userName);
            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
}
