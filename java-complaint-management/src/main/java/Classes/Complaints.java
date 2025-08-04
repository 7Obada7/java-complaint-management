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
public class Complaints {

    private int formNo;
    private String id;
    private String status;
    private String detailsOfComplaint;
    private String sloution;
    private String product;

    public Complaints(int formNo, String id, String status, String detailsOfComplaint, String sloution, String product) {
        this.formNo = formNo;
        this.id = id;
        this.status = status;
        this.detailsOfComplaint = detailsOfComplaint;
        this.sloution = sloution;
        this.product = product;
    }
public Complaints(String status, String product,String sloution) {
       
        this.status = status;
        this.sloution = sloution;
        this.product = product;
    }

    public int getFormNo() {
        return formNo;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDetailsOfComplaint() {
        return detailsOfComplaint;
    }

    public String getSloution() {
        return sloution;
    }

    public String getProduct() {
        return product;
    }

}
