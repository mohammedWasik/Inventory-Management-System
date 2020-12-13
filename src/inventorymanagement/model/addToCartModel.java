/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagement;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author wasik
 */
public class addToCartModel {
    
     public void addToCart(JTable saleTable,JTable billTable, int ttotal, JTextField total,JTextField price,JTextField qty) {
        try {

            TableModel model1 = saleTable.getModel();
            int indexs = saleTable.getSelectedRow();
            //System.out.println("index length : "+indexs.length);

            Object[] row = new Object[9];

            DefaultTableModel model2 = (DefaultTableModel) billTable.getModel();

            int p = Integer.parseInt(qty.getText()) * Integer.parseInt(price.getText());
            row[0] = model1.getValueAt(indexs, 0);
            row[1] = model1.getValueAt(indexs, 1);
            row[2] = p;
            row[3] = qty.getText();
            row[4] = model1.getValueAt(indexs, 4);
            row[5] = model1.getValueAt(indexs, 5);
            row[6] = model1.getValueAt(indexs, 6);
            row[7] = model1.getValueAt(indexs, 7);
            row[8] = model1.getValueAt(indexs, 8);

            model2.addRow(row);
            ttotal = ttotal + p;
            total.setText(String.valueOf(ttotal));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
