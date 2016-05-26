/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jo_as
 */
public class MyTableDefault extends AbstractTableModel {

    private String coluna;
    private Object[] lista;

    public MyTableDefault(Object[] lista, String coluna){
        this.coluna = coluna;
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = lista[rowIndex];
        return o.toString();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return coluna;
    }

}
