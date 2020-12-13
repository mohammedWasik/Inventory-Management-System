/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement.controller;

import inventorymanagement.model.searchFetchModel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author wasik
 */
public class searchController {
    
   public void fetch(JTextField searchBox, JTable prodTable){
        searchFetchModel s = new searchFetchModel();
        s.fetch(searchBox, prodTable);
   }
}
