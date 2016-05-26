/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author JOAO
 */
public class Example implements TableObjectInterface {//Um examplo bobo para inlustrar como seria seu objeto

    private Object[] atts;

    public Example(String titulo, String autor, String editora) {
        atts = new Object[]{titulo, autor, editora, false};
    }

    @Override
    public Object[] atributeToTable() {
        return  atts;
    }

}
