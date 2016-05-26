/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonatas.api;

import java.util.HashMap;
import java.util.LinkedList;
import org.apache.jena.ontology.OntClass;

/**
 *
 * @author jo_as
 */
public class MapOntClass extends HashMap<OntClass, Object[]> {

    MapOntClass(JOnto utils, String... roots) {
        fillMap(utils, roots);//Este é metodo usado de forma recusiva para preencher o map, fill é preencher em inglês
    }

    private void fillMap(JOnto utils, Object[] roots) {//De novo o primeiro a executar é este depois fica só no segundo
        for (Object root : roots) {//o objeto roots, pode ser pensado como um conjuto de querys.
            OntClass key = utils.readOntologia(root.toString());//select ontClass from your_base where local_name = root, para facilitar sua ideia.
            if (key != null) {
                this.putIfAbsent(key, utils.readInstances(key).toArray());//select instances from base where ontClass = key
                LinkedList<OntClass> aux = utils.listSubClass(key);//select subClass from base where ontClass = key
                if (!aux.isEmpty()) {//só para evitar erros
                    fillMap(utils, aux);//agora passa para o fillmap de baixo
                }
            }
        }
    }

    private void fillMap(JOnto utils, LinkedList<OntClass> keys) {
        for (OntClass key : keys) {//caso ele encontro uma lista de ontClass com valores null ele irá parar, e é isto, ele faz a mesma coisa que o de cima
            if (key != null) {
                this.putIfAbsent(key, utils.readInstances(key).toArray());
                LinkedList<OntClass> aux = utils.listSubClass(key);//outra coisa anda demorando um pouco para iniciar
                // a view pq ele tem que fazer tudo isto para gerar os maps e o tree model
                if (!aux.isEmpty()) {
                    fillMap(utils, aux.toArray());
                }
            }
        }
    }

}
