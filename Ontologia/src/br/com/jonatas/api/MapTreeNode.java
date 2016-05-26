/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonatas.api;

import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.jena.ontology.OntClass;

/**
 *
 * @author jo_as
 */
public class MapTreeNode extends DefaultMutableTreeNode {

    private OntClass value;

    public MapTreeNode(String title) {
        super(title);//Isto faz o titulo assunto aparecer no node lá na view
    }    
    
    public MapTreeNode(JOnto jo, OntClass root) {//da qui para frente é tudo iqual
        super(root.getLabel("PT"));//isto para aparecer o nome na view, sem isto fica em branco lá
        value = root;//salva o ontClass
        if (root != null) {
            for (OntClass arg : jo.listSubClass(root)) {
                this.add(new MapTreeNode(jo, arg));//agora ele executa ele mesmo de novo, isto é uma recursividade
            }
        }
    }

    public OntClass getValue() {
        return value;
    }

    public void setValue(OntClass value) {
        this.value = value;
    }

    public boolean hasValue() {
        return value != null;//isto é muito util
    }

}
