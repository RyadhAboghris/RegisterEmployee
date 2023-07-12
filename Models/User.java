/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.BitSet;

/**
 *
 * @author ryadh
 */
public class User {

    private String userName;
    private String name;
    private String password;
    private String role;
    private byte[] image;
    private int active;

    public User(String userName, String name, String password, String role, byte[] image, int active) {
        this.userName = userName;
        this.name = name;
        this.password = password;
        this.role = role;
        this.image = image;
        this.active = active;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public byte[] getImage() {
        return image;
    }

    public int getActive() {
        return active;
    }
    
}
