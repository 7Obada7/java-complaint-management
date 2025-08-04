/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.Database.connection;
import static Classes.Database.formNo;
import static Classes.Database.state;
import com.mycompany.proje3.ComplaintsInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author obama
 */
public abstract class Database {

    static Connection connection;
    static Statement state;
    static ResultSet result;
    DefaultTableModel dtm = new DefaultTableModel();
//starts the server connection

    public static void Start_connection() throws SQLException {
        // Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proje", "root", "");

    }
//insert statement
    public static void Insert(String query) throws SQLException {
        state = connection.createStatement();
        state.executeUpdate(query);
        state.close();
    }

    //checks if the id has been used before or not
    public static <T> boolean isUnique(T id) throws SQLException {
        boolean b = true;
        state = connection.createStatement();
        result = state.executeQuery("SELECT id FROM users WHERE id = '" + id + "'");
        if (result.next()) {
            b = false;
        }
        return b;
    }
//select statement

    public static User getInformation(String id) throws SQLException {

        state = connection.createStatement();
        result = state.executeQuery("SELECT * FROM userInfo WHERE id = '" + id + "'");

        User u1 = null;
        if (result.next()) {
            String name = result.getString("name");
            String phone = result.getString("phone");
            String email = result.getString("email");
            String password = result.getString("password");
            String rePassword = result.getString("rePassword");
            String dateOfBirth = result.getString("dateOfBirth");
            u1 = new User(name, phone, email, id, password, rePassword, dateOfBirth);

        }

        return u1;
    }

    public static DefaultListModel unsolvedComplaintList() throws SQLException {
        DefaultListModel model = new DefaultListModel();
        String status = "unsolved";
        String Complain;
        state = connection.createStatement();
        result = state.executeQuery("SELECT * FROM complaints WHERE status ='" + status + "'");
        while (result.next()) {
            int formNo = result.getInt("FormNo");
            String product = result.getString("product");
            Complain = formNo + "-" + product;
            model.addElement(Complain);
        }

        return model;

    }

    public static Complaints getComplaintInfo(int formNo) throws SQLException {
        Complaints c = null;
        state = connection.createStatement();
        result = state.executeQuery("SELECT * FROM complaints WHERE formNo ='" + formNo + "'");
        if (result.next()) {
            String id = result.getString("id");
            String status = result.getString("status");
            String detailsOfComplaint = result.getString("detailsOfComplaint");
            String sloution = result.getString("sloution");
            String product = result.getString("product");
            c = new Complaints(formNo, id, status, detailsOfComplaint, sloution, product);
        }
        return c;
    }
//update statement

    public static void addSolve(String solve, Complaints c) throws SQLException {
        state = connection.createStatement();
        state.executeUpdate("UPDATE complaints SET sloution='" + solve + "' WHERE FormNo='" + c.getFormNo() + "'");
        changeStatus("solved", c);
        state.close();

    }

    public static void changeStatus(String status, Complaints c) throws SQLException {
        state = connection.createStatement();
        state.executeUpdate("UPDATE complaints SET status='" + status + "' WHERE FormNo='" + c.getFormNo() + "'");

    }

    public static int formNo(String c) {
        int formNO = 0;
        if (c != null) {
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) == '-') {
                    formNO = Integer.parseInt(c.substring(0, i));
                    break;
                }

            }
        }
        return formNO;
    }

    public static ArrayList<Complaints> addToTable(String id) throws SQLException {
        state = connection.createStatement();
        result = state.executeQuery("SELECT * FROM complaints WHERE id ='" + id + "'");
        ArrayList<Complaints> tableInfoList = new ArrayList<Complaints>();
        while (result.next()) {
            String status = result.getString("status");
            String product = result.getString("product");
            String sloution = result.getString("sloution");
            Complaints u1 = new Complaints(status, product, sloution);
            tableInfoList.add(u1);
        }

        return tableInfoList;
    }
    

   

}
