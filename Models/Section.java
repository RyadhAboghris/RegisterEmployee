/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ryadh
 */
public class Section {
    private String name;
    private String details;
    private byte[] image;

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }



    public void setName(String name) {
        this.name = name;
    }




    public void setDetails(String details) {
        this.details = details;
    }



    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Section( String name, String details, byte[] image) {
        this.name = name;
        this.details = details;
        this.image = image;
    }



    public Section() {
    }


    
}
