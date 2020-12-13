/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.model.catFetchModel;
import inventorymanagement.model.fetchModel;
import inventorymanagement.model.insertModel;
import inventorymanagement.model.rowSelectModel;
import inventorymanagement.model.updateModel;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class inventoryController {

    public void fetch(JTable inTable) {
        fetchModel f = new fetchModel();
        f.fetch(inTable);
    }

    public void catFetch(int i, JTable inTable) {
        catFetchModel c = new catFetchModel();
        c.catFetch(i, inTable);
    }

    public void clearSelection(ButtonGroup buttonGroup) {
        buttonGroup.clearSelection();
    }

    public void rowSelect(JTable itemTable, JTextField name, JTextField price, JTextField quantity, JTextField category, JTextField wareid, JTextField active) {
        rowSelectModel r = new rowSelectModel();
        r.rowSelect(itemTable, name, price, quantity, category, wareid, active);
    }

    public void clear(JTextField name, JTextField price, JTextField quantity, JTextField category, JTextField wareid, JTextField active) {
        insertModel i = new insertModel();
        i.clearJTxtFld(name, price, quantity, category, wareid, active);
    }

    public void update(JTable itemTable, JTextField name, JTextField price, JTextField quantity, JTextField category, JTextField wareid, JTextField active) {
        updateModel u = new updateModel();
        u.update(itemTable, name, price, quantity, category, wareid, active);
    }

    public void insert(JTable itemTable, JTextField name, JTextField price, JTextField quantity, JTextField category, JTextField wareid, JTextField active) {
        inventoryController i = new inventoryController();
        i.insert(itemTable, name, price, quantity, category, wareid, active);
    }
}
