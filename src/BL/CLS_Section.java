/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BL;

import DAL.DAL;
import Models.Section;
import Models.User;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ryadh
 */
public class CLS_Section {
    DAL dal;

    public CLS_Section() {
        this.dal = DAL.getInstance();
    }

    
     public void addOne(String name,String details,byte [] image) {
        try {
            dal.ps = dal.conn.prepareStatement("insert into tbl_sections(name,details,image)values(?,?,?)");
            dal.ps.setString(1, name);
            dal.ps.setString(2, details);
             dal.ps.setBytes(3, image);    
            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
public void updateOne(String name,String details,byte [] image,String nm) {
        try {
            dal.ps = dal.conn.prepareStatement("update tbl_sections set  name=? , details=? , image=? where name=?");
              dal.ps.setString(1, name);
            dal.ps.setString(2, details);
             dal.ps.setBytes(3, image);   
             dal.ps.setString(4, nm);   
  
             

            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
    public ArrayList<Section>  getAll() {
        try {
            dal.rs = dal.stmt.executeQuery("select * from tbl_sections");
            ArrayList<Section> sections = new ArrayList<Section>();
            while (dal.rs.next()) {
                sections.add(new Section(dal.rs.getString("name"),dal.rs.getString("details"),dal.rs.getBytes("image")));
            }
            return sections;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteOne(String name) {
        try {
            dal.ps = dal.conn.prepareStatement("delete tbl_sections where name=?");
            dal.ps.setString(1, name);
            dal.ps.executeUpdate();
        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Here error");

        }
    }
    
    public ArrayList<Section> search(String str, int currentRow) {
        try {
/// where + user_name + name  like '%'+?+'%' order by user_name  offset ? rows fetch next 20 rows only
//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_sections where + name + details   like '%'+?+'%' order by name  offset ? rows fetch next 20 rows only");
            dal.ps.setString(1, str);
            dal.ps.setInt(2, currentRow);
            dal.rs = dal.ps.executeQuery();
            ArrayList<Section> section = new ArrayList<Section>();
            while (dal.rs.next()) {
                section.add(new Section(dal.rs.getString("name"),dal.rs.getString("details"),dal.rs.getBytes("image")));
            }
            return section;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("here");
        }
        return null;
    }
    
        public int amountOfRows(String str) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select count(name) as amount from tbl_sections where + name + details  like '%'+?+'%'  ");
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
        
        public Section getOne(String name) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_sections where name=?");
            dal.ps.setString(1, name);
            dal.rs = dal.ps.executeQuery();
            while (dal.rs.next()) {
                return new Section(dal.rs.getString("name"),dal.rs.getString("details"),dal.rs.getBytes("image"));
                        
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
         public boolean checkSectionName(String sectionName) {
        try {

//            ResultSet rs = dal.stmt.executeQuery("select * from tbl_users");
            dal.ps = dal.conn.prepareStatement("select * from tbl_sections where name=?");
            dal.ps.setString(1, sectionName);
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
