/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.addToCartModel;
import inventorymanagement.model.catFetchModel;
import inventorymanagement.model.checkoutModel;
import inventorymanagement.model.sFetchModel;
import inventorymanagement.model.saleFetchModel;
import inventorymanagement.saleRowSelectModel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class saleController {

    public void checkout(JTable billTable) {
        checkoutModel c = new checkoutModel();
        c.checkout(billTable);
    }

    public void sf(JTable saleTable, JTable billTable) {
        saleFetchModel s = new saleFetchModel();
        s.fetch(saleTable, billTable);
    }

    public void add2cart(JTable saleTable, JTable billTable, int ttotal, JTextField total, JTextField price, JTextField qty) {
        addToCartModel a = new addToCartModel();
        a.addToCart(saleTable, billTable, ttotal, total, price, qty);
    }

    public void search(JTable saleTable, JTextField searchbox, JTextField name) {
        sFetchModel s = new sFetchModel();
        s.seaFetch(saleTable, searchbox, name);
    }

    public void cat(int i, JTable saleTable) {
        catFetchModel c = new catFetchModel();
        c.catFetch(i, saleTable);
    }

    public void rowselect(JTable saleTable, JTextField name, JTextField price, JTextField cat, JTextField qty) {
        saleRowSelectModel s = new saleRowSelectModel();
        s.rowSelect(saleTable, name, price, cat, qty);
    }

    
}
