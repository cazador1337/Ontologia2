/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import org.apache.jena.rdf.model.RDFNode;

/**
 *
 * @author jo_as
 */
public class Temas implements TableObjectInterface{
    private String titulo, nome;

    public Temas(String titulo, String nome) {
        this.titulo = titulo;
        this.nome = nome;
    }     
    
    @Override
    public Object[] atributeToTable() {
        return new Object[]{titulo, nome};
    }

    @Override
    public String toString() {
        return titulo;
    }
    
        
}
