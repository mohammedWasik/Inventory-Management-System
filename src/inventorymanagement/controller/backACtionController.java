/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.view.loginPage;
import inventorymanagement.view.Index;
import inventorymanagement.view.indexAdmin;

/**
 *
 * @author wasik
 */
public class backACtionController {
        public void back() {
        int i = loginPage.uType;
        if (i == 0) {
            Index index = new Index();
            index.setVisible(true);
        } else {
            indexAdmin in = new indexAdmin();
            in.setVisible(true);
            in.setLocationRelativeTo(null);

        }
    }
    
}
