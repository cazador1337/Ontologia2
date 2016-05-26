/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonatas.api;

import java.util.Iterator;
import java.util.LinkedList;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author jo_as
 */
public class JOnto {//Este Cara se vc for pensar no modelo MVC este é seu Controller

    private static final String BASE_URI = "http://www.semanticweb.org/joaopaulovolpate/ontologies/2016/0/untitled-ontology-10#",
            SOURCE = "Livros.owl";
    //Fiz estatico eles, para facilitar num provavel mudança no futuro
    private static final String[] TREE_ROOT = {"Softwares_e_suas_Engenharias"};//se quiser adicionar mais um root a árvore, coloca aqui.

    public JOnto() {
        LogCtl.setCmdLogging();//vc disse que tem que fazer isto logo no incio então coloquei no seu contrutor, mas falando a verdade nem sei,
        //para que isto serve
    }

    public OntClass readOntologia(String query) {//Percebi que este cara era muito paracido com um select, ele é iqual ao seu metodo antigo
        //mas mudei os nomes de algumas coisas, ele é o mesmo metodo lerOntologia da classe Ontologias.java
        OntModel model;
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);
        model.read(SOURCE);
        OntClass result = model.getOntClass(BASE_URI + query);
        return result;
    }

    public MapTreeNode newModelTree(String args) {//Este cara cria o modelo para o Tree node da view
        MapTreeNode root = new MapTreeNode(this, this.readOntologia(args));        
        return root;
    }

    public MapTreeNode newModelTree() {
        return newModelTree(TREE_ROOT[0]);
    }

    public LinkedList<String> readInstances(OntClass source) {
        LinkedList<String> result = new LinkedList<>();
        for (Iterator i = source.listInstances(false); i.hasNext();) {
            Individual indi = (Individual) i.next();
            String s = indi.getLabel("PT");
            result.add(s);
        }
        return result;
    }

    public LinkedList<OntClass> listSubClass(OntClass root) {
        LinkedList<OntClass> result = new LinkedList<>();
        for (Iterator i = root.listSubClasses(); i.hasNext();) {
            OntClass c = (OntClass) i.next();
            result.add(c);
        }
        return result;
    }

    public MapOntClass newMapOntClass(String... roots) {
        return new MapOntClass(this, roots);//Isto inicia a criaçã do Map, o map é criado de forma recursiva. leia a classe MapOntClass
    }

    public MapOntClass newMapOntClass() {
        return newMapOntClass(TREE_ROOT);
    }
}
