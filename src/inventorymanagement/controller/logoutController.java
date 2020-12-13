/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.view.loginPage;
import javax.swing.JOptionPane;

/**
 *
 * @author wasik
 */
public class logoutController {

    public void logout() {
        int a = JOptionPane.showConfirmDialog(null, "Are you sure ?");
        if (a == JOptionPane.YES_OPTION) {
            loginPage login = new loginPage();
            login.setVisible(true);
         
        }
    }
}
