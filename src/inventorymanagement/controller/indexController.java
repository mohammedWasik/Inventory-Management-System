/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.history;
import inventorymanagement.view.inventory;
import inventorymanagement.view.inventoryaddsub;
import inventorymanagement.view.profile;
import inventorymanagement.view.sale;
import inventorymanagement.search;
import inventorymanagement.model.showlowstock;
import javax.swing.JTable;

/**
 *
 * @author wasik
 */
public class indexController {
    
    public void stock(JTable jTable1){
        showlowstock s = new showlowstock();
        s.showLowStock(jTable1);
    }
     public void inventory() {
        inventory in = new inventory();
        in.setLocationRelativeTo(null);
        in.setVisible(true);
    }

    public void history() {
        history his = new history();
        his.setLocationRelativeTo(null);
        his.setVisible(true);
    }

    public void search() {
        search sch = new search();
        sch.setLocationRelativeTo(null);
        sch.setVisible(true);

    }

    
    public void profile(){
        profile p = new profile();
        p.setVisible(true);
    }
    
    public void sale(){
        sale s = new sale();
        s.setVisible(true);
    }
    
    public void inventoryAddSub(){
        inventoryaddsub i = new inventoryaddsub();
        i.setVisible(true);
    }
}
