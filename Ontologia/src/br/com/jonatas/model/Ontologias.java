/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonatas.model;

import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;



/**
 *
 * @author jo_as
 */
public class Ontologias {
    
    static public OntClass lerOntologia(String arvore){
        
        LogCtl.setCmdLogging();

        String baseURI = "http://www.semanticweb.org/joaopaulovolpate/ontologies/2016/0/untitled-ontology-10#";
        OntModel model;
        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);
        model.read("Livros.owl");
        OntClass assuntos = model.getOntClass(baseURI + arvore); 
        return assuntos;
    }
    
    
}       
