/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.model.loginModel;
import static inventorymanagement.view.loginPage.name;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class loginPageController {
    
    public void login(String name, JTextField username, JPasswordField password,int uType){
        loginModel lm = new loginModel();
        lm.loggin(name, username, password,uType);
    }

   
    
}
