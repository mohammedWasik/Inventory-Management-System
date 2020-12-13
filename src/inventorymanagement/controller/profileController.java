/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.model.pfetchModel;
import inventorymanagement.model.saveModel;
import java.awt.TextField;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class profileController {
    
    public void pf(JTextField username, JTextField pass, JTextField email, JTextField phone, JTextField fname, JTextField lname){
        pfetchModel p = new pfetchModel();
        p.pfetch(username, pass, email, phone, fname, lname);
    }

   public void save(JTextField username, JTextField pass, JTextField email, JTextField phone, JTextField fname, JTextField lname){
       
       saveModel sv = new saveModel();
        sv.save(username, pass, email, phone, fname, lname);
   }
}
