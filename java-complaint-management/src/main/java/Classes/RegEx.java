/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author obama
 */
public class RegEx {
//matcher method matches the input with the pattern

    public static boolean matcher(String pattern, String match) {
        boolean status = false;
        Matcher matcher;
        matcher = Pattern.compile(pattern).matcher(match);
        if (matcher.matches()) {
            status = true;
        }
        return status;
    }
//checks the validity of the input entered by the user

    public static boolean inputCheck(JPanel jPanel, JTextField name, JTextField email, JTextField id, JTextField phone, String gender, String dateOfBirth, JCheckBox chk_clarify, JPasswordField password, JPasswordField repassword) {
        boolean status = true;
        if (name.getText().isEmpty() || email.getText().isEmpty() || id.getText().isEmpty() || phone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jPanel, "Fill all the empty areas", "error", JOptionPane.OK_OPTION);
            status = false;
        } else {
            if (matcher("[a-zA-a]+", name.getText()) == false) {
                JOptionPane.showMessageDialog(jPanel, "your name is not correct plese use valid characters", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if (matcher("[a-zA-z0-9]{5,30}", password.getText()) == false) {
                JOptionPane.showMessageDialog(jPanel, "the password you entered is invalid or it is not at least 5 charachters long ", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if (matcher("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", email.getText()) == false) {
                JOptionPane.showMessageDialog(jPanel, "the email you entered is not valid ", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if (password.getText().compareTo(repassword.getText()) != 0) {
                JOptionPane.showMessageDialog(jPanel, "your password does not match ", "error", JOptionPane.OK_OPTION);
                repassword.setText("");
                status = false;
            } else if (matcher("[0-9]+", id.getText()) == false) {
                JOptionPane.showMessageDialog(jPanel, "the id you entered is invalid please enter numbers only", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if ((id.getText().length()) != 11) {
                JOptionPane.showMessageDialog(jPanel, "the id you entered is invalid please enter an 11 digit id", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if (matcher("[0-9]+", phone.getText()) == false) {
                JOptionPane.showMessageDialog(jPanel, "the phone number you entered is not valid please enter numbers only", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if ((phone.getText().length()) != 11) {
                JOptionPane.showMessageDialog(jPanel, "the phone number you entered is invalid please enter an 11 digit phone number", "error", JOptionPane.OK_OPTION);
                status = false;
            } else if (!chk_clarify.isSelected()) {
                JOptionPane.showMessageDialog(jPanel, "you have not checked the box", "Warning", JOptionPane.WARNING_MESSAGE);
                status = false;
            }
        }
        return status;
    }
//checks if the id and the password matches the one entered when registering

    public static boolean passwordCheck(JPanel panel,String password, String orgPassword) {
        boolean status = true;
        if (password.length() == orgPassword.length()) {
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == orgPassword.charAt(i)) {
                    status = true;
                } else {
                    JOptionPane.showMessageDialog(panel, "your password does not match", "Warning", JOptionPane.WARNING_MESSAGE);
                    status = false;
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(panel, "your password does not match", "Warning", JOptionPane.WARNING_MESSAGE);
            status = false;
        }

        return status;
    }

   
    public static boolean LoginInputCheck(JPanel jPanel1, String id, String password) {
        boolean stat = true;
        if (id.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(jPanel1, "Your Must Fill All The Areas", "error", JOptionPane.OK_OPTION);
            stat = false;

        } else {

            if (matcher("[0-9]+", id) == false) {
                JOptionPane.showMessageDialog(jPanel1, "your tc number is not valid please use only digits", "error", JOptionPane.ERROR_MESSAGE);
                stat = false;
            }
            else if (id.length() != 11) {
                JOptionPane.showMessageDialog(jPanel1, "Your Tc Number Should Contain 11 Digits ", "error", JOptionPane.OK_OPTION);
                stat = false;
            }
            
        }
        return stat;

        }
} 


