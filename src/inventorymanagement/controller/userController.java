/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.userDeleteModel;
import inventorymanagement.userInitialFetchModel;
import inventorymanagement.userInsertModel;
import inventorymanagement.userRowSelectModel;
import inventorymanagement.userUpdateModel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class userController {
    public void fetch(JTable utable){
        userInitialFetchModel u = new userInitialFetchModel();
        u.initialFetch(utable);
    }
    public void insert(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField pass, JTextField uname,JTextField phone,JTextField type){
         userInsertModel uu = new userInsertModel();
            uu.insert(utable, warehouse, fname, lname, email, uname, pass, phone, type);
    }
    public void rowselect(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField pass, JTextField uname,JTextField phone,JTextField type){
         userRowSelectModel uu = new userRowSelectModel();
        uu.rowSelect(utable, warehouse, fname, lname, email, uname, pass, phone, type);
    }
    public void clear(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField pass, JTextField uname,JTextField phone,JTextField type){
         userUpdateModel uu = new userUpdateModel();
        uu.clearJTxtFld(warehouse, fname, lname, email, uname, pass, phone, type);
    }
    public void delete(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField pass, JTextField uname,JTextField phone,JTextField type){
         userDeleteModel uu = new userDeleteModel();
        uu.delete(utable, warehouse, fname, lname, email, uname, pass, phone, type);
    }
    public void update(JTable utable, JTextField warehouse, JTextField fname,JTextField lname, JTextField email, JTextField pass, JTextField uname,JTextField phone,JTextField type){
         userUpdateModel uu = new userUpdateModel();
        uu.update(utable, warehouse, fname, lname, email, uname, pass, phone, type);
    }
}
