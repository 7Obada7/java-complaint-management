/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author obama
 */

public class User {

    private String name;
    private String phone;
    private String email;
    private String id;
    private String password;
    private String repassword;
    private String dateOfBirth;
//makes a new object to save the information entered by the user inside of it
    public User(String name, String phone, String email, String id, String password, String repassword, String dateOfBirth) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id = id;
        this.password = password;
        this.repassword = repassword;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getRepassword() {
        return repassword;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

}
