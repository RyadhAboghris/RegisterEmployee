/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.logging.Logger;

/**
 *
 * @author ryadh
 */
public class Employee {
    private String id; 
    private String name;   
    private String section;
    private int phoneNumber;
    private String email;  
    private String location;
    private byte[] image;

    public Employee() {
    }

    public Employee(String id, String name, String section, int phoneNumber, String email, String location, byte[] image) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.location = location;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public byte[] getImage() {
        return image;
    }
    
    
}
